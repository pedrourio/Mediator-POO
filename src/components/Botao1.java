package components;

import core.Widget;
import core.DialogDirector;

public class Botao1 implements Widget{
    private DialogDirector director;
    private String nome;

    public Botao1(String nome, DialogDirector director){
        this.nome = nome;
        this.director = director;
    }

    public String getNome(){
        return nome;
    }

    public void clicar(){
        changed();
    }

    @Override
    public void changed(){
        director.widgetChanged(this);
    }

}
