Encontrei tudo! Aqui estão as melhores passagens do livro GoF para sua apresentação:

---

## Citações e conteúdo do GoF — Padrão Mediator

### 1. INTENT — A definição canônica (slide de abertura perfeito)

> **"Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently."**

*(p. 273 — esta é a definição oficial, a mais citada em toda a literatura)*

---

### 2. MOTIVATION — O problema que ele resolve

> **"Object-oriented design encourages the distribution of behavior among objects. Such distribution can result in an object structure with many connections between objects; in the worst case, every object ends up knowing about every other."**

E a solução proposta:

> **"You can avoid these problems by encapsulating collective behavior in a separate mediator object. A mediator is responsible for controlling and coordinating the interactions of a group of objects. The mediator serves as an intermediary that keeps objects in the group from referring to each other explicitly. The objects only know the mediator, thereby reducing the number of interconnections."**

E o detalhe mais elegante do exemplo com widgets:

> **"Widgets communicate with each other only indirectly, through the director. They don't have to know about each other; all they know is the director."**

---

### 3. CONSEQUENCES — Vantagens e a desvantagem honesta

Os 5 pontos exatos do livro:

| #   | Consequência                                                                                                                                                     | Tipo           |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------- |
| 1   | **Limits subclassing** — localizes behavior; Colleague classes can be reused as is                                                                               | ✅ Vantagem    |
| 2   | **Decouples colleagues** — you can vary and reuse Colleague and Mediator classes independently                                                                   | ✅ Vantagem    |
| 3   | **Simplifies object protocols** — replaces many-to-many with one-to-many; easier to understand, maintain, and extend                                             | ✅ Vantagem    |
| 4   | **Abstracts how objects cooperate** — helps clarify how objects interact in a system                                                                             | ✅ Vantagem    |
| 5   | **Centralizes control** — *"trades complexity of interaction for complexity in the mediator... can make the mediator itself a monolith that's hard to maintain"* | ❌ Desvantagem |

A desvantagem (consequência 5) é especialmente boa para slide porque os próprios autores admitem o trade-off sem romantizar.

---

### 4. RELATED PATTERNS — Comparação com Facade e Observer

> **"Facade differs from Mediator in that it abstracts a subsystem of objects to provide a more convenient interface. Its protocol is unidirectional; that is, Facade objects make requests of the subsystem classes but not vice versa. In contrast, Mediator enables cooperative behavior that colleague objects don't or can't provide, and the protocol is multidirectional."**

> **"Colleagues can communicate with the mediator using the Observer pattern."**

---

### Minha recomendação de slide mais impactante

Se você puder colocar só **uma** frase como citação de destaque na apresentação, use esta da Motivation:

> *"in the worst case, every object ends up knowing about every other."*

E contraponha com a do Intent:

> *"Mediator promotes loose coupling by keeping objects from referring to each other explicitly."*

Essa dupla conta a história toda em duas linhas — problema e solução — direto da fonte mais respeitada da área.