package screens;

import core.DialogDirector;
import core.Widget;
import components.*;


public class FontDialogDirector extends DialogDirector{
    private Botao1 botao1;
    private Botao2 botao2;

    public void setBotao1(Botao1 btn1){
        this.botao1 = btn1;
    }

    public void setBotao2(Botao2 btn2){
        this.botao2 = btn2;
    }

    private int n = 0;
    @Override
    public void handleBotao1Change(Widget widget){
        System.out.println("Mediador sendo chamado " + ++n +  " vez");
        botao2.mudarTexto("Texto Mudado");
    }
    
    
}
