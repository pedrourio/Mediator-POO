package components;

import javax.swing.JButton;
import core.Widget;
import core.DialogDirector;

public class Botao1 extends JButton implements Widget{
    private DialogDirector director;
    String nome;

    public Botao1(DialogDirector director, String nome){
        super(nome);
        this.director = director;
    }

    @Override
    public void changed(){
        //funcao de trigger do mediador
        
        director.handleBotao1Change(this);
    }

}
