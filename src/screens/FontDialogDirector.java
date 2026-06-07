package screens;

import core.DialogDirector;
import core.Widget;

public class FontDialogDirector extends DialogDirector{
    @Override
    public void widgetChanged(Widget widget){
        //funcao de reação a mudança do widget
    }

    @Override
    public void showDialog(){
        System.out.println("Exibindo o form na tela");
    }
    
}
