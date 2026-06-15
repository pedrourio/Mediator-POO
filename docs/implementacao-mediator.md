# Implementação do padrão Mediator

Este documento explica as alterações feitas para sair do esqueleto e ter o
padrão Mediator a funcionar de ponta a ponta, no estilo do exemplo do livro
*Design Patterns* (GoF) — o `FontDialogDirector`.

## O problema que o Mediator resolve

Numa janela de diálogo, os componentes (botões, campos, listas) costumam
depender uns dos outros. Se cada componente conhece e mexe diretamente nos
outros, o resultado é um emaranhado acoplado e nada reutilizável.

O Mediator centraliza essa comunicação: em vez de os widgets falarem entre si,
todos falam com um intermediário (o *director*). O widget só anuncia "eu
mudei"; o director decide o que fazer com os outros. Os widgets deixam de se
conhecer — só conhecem o director.

## Estrutura

| Peça do padrão        | Classe                  |
|-----------------------|-------------------------|
| Mediator (abstrato)   | `core.DialogDirector`   |
| ConcreteMediator      | `screens.FontDialogDirector` |
| Colleague (interface) | `core.Widget`           |
| ConcreteColleagues    | `components.Botão1`, `components.CampoTexto` |
| Ponto de entrada      | `mediator.Mediator`     |

Organização em pacotes:

- `core/` — as abstrações reutilizáveis (`Widget`, `DialogDirector`).
- `components/` — widgets concretos (`Botão1`, `CampoTexto`).
- `screens/` — mediators concretos, um por ecrã (`FontDialogDirector`).
- `mediator/` — ponto de entrada da aplicação (`Mediator.main`).

## As alterações, passo a passo

### 1. Widgets com estado e identidade

`Botão1` ganhou um `nome` e um método `clicar()` que simula a interação do
utilizador e dispara `changed()`. Foi adicionado um segundo widget,
`CampoTexto`, com estado próprio (`texto`) e `getTexto()`/`setTexto()`.

Os widgets são "puros": guardam estado e sabem apenas disparar `changed()`.
Não conhecem outros widgets nem produzem saída — isso é responsabilidade do
director.

### 2. O director conhece os seus widgets

`DialogDirector` passou a declarar `protected abstract void createWidgets()`.
O `FontDialogDirector` guarda referências aos widgets que coordena (`ok` e
`nomeFonte`) e implementa `createWidgets()`, instanciando cada um e ligando-o
a `this`.

### 3. Lógica de coordenação em `widgetChanged()`

O `FontDialogDirector.widgetChanged()` identifica qual widget mudou por
identidade de referência (`==`) e reage nos outros:

```java
if (widget == ok) {
    System.out.println("Aplicando a fonte: " + nomeFonte.getTexto());
}
```

É o director a ler/escrever noutro widget em resposta a um evento, sem que os
widgets se conheçam entre si.

### 4. `showDialog()` monta o diálogo

O `showDialog()` chama `createWidgets()` (sem isso os campos ficariam `null`),
dá um valor inicial ao `nomeFonte` e exibe. É o ponto de entrada do ciclo de
vida do diálogo.

### 5. Ponto de entrada `mediator.Mediator`

O `main` (no pacote que o projeto NetBeans espera, `main.class=mediator.Mediator`)
cria o director, chama `showDialog()` e simula um clique. Nunca liga um widget
a outro — só inicia o diálogo e dispara um evento.

## Fluxo em execução

```
main: director.getOk().clicar()
        │
   Botão1.clicar() ──► changed()
        │
   director.widgetChanged(this)        (this = o botão ok)
        │
   FontDialogDirector.widgetChanged():
        if (widget == ok)  →  lê nomeFonte.getTexto() = "Arial"
        │
   imprime "Aplicando a fonte: Arial"
```

Saída ao correr `mediator.Mediator`:

```
Exibindo o form na tela
Aplicando a fonte: Arial
```

## Nota sobre `Widget` como interface

No livro (C++) o `Widget` é uma classe base que guarda o director e implementa
`Changed()` uma única vez. Em Java mantemos `Widget` como interface de
propósito: permite que um widget faça `extends JButton implements Widget` no
futuro (Java não tem herança múltipla de classes). O custo é cada widget
repetir o campo `director` e o método `changed()`.

## Próximos passos possíveis

- Adicionar um terceiro widget (ex. uma lista de fontes que atualiza o
  `nomeFonte`), como no exemplo original do livro.
- Evoluir para uma versão com Swing (`JButton`), onde a escolha de `Widget`
  como interface compensa.
