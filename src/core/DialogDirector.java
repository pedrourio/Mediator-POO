package core;


/**
 * @author pedro
 * @author becker
 */

public abstract class DialogDirector {

    public abstract void widgetChanged(Widget widget);
    public abstract void showDialog();
    protected abstract void createWidgets();
}
