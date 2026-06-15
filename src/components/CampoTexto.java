package components;

import core.Widget;
import core.DialogDirector;

public class CampoTexto implements Widget{
    private DialogDirector director;
    private String nome;
    private String texto = "";

    public CampoTexto(String nome, DialogDirector director){
        this.nome = nome;
        this.director = director;
    }

    public String getNome(){
        return nome;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    @Override
    public void changed(){
        director.widgetChanged(this);
    }

}
