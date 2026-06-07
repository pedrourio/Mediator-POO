package core;


/**
 * @author pedro
 * @author becker
 */

public abstract class DialogDirector {
    
    /*
    widgetChanged() -> chamado pelo widget quando realizado uma ação
    showDialog() -> funcao que invoca o mediador
    */
    public abstract void widgetChanged(Widget widget);
    public abstract void showDialog();
}


