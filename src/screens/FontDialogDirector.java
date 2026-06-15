package screens;

import core.DialogDirector;
import core.Widget;
import components.Botão1;
import components.CampoTexto;

public class FontDialogDirector extends DialogDirector{
    private Botão1 ok;
    private CampoTexto nomeFonte;

    @Override
    protected void createWidgets(){
        ok = new Botão1("OK", this);
        nomeFonte = new CampoTexto("nomeFonte", this);
    }

    @Override
    public void widgetChanged(Widget widget){
        if (widget == ok) {
            System.out.println("Aplicando a fonte: " + nomeFonte.getTexto());
        }
    }

    @Override
    public void showDialog(){
        createWidgets();
        nomeFonte.setTexto("Arial");
        System.out.println("Exibindo o form na tela");
    }

    public Botão1 getOk(){
        return ok;
    }

    public CampoTexto getNomeFonte(){
        return nomeFonte;
    }

}
