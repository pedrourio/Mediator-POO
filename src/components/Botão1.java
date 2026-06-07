package components;

import core.Widget;
import core.DialogDirector;

public class Botão1 implements Widget{
    private DialogDirector director;

    public Botão1(DialogDirector director){
        this.director = director;
    }

    @Override
    public void changed(){
        //funcao de trigger do mediador
        director.widgetChanged(this);
    }

}