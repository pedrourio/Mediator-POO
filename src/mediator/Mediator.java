package mediator;

import screens.FontDialogDirector;

public class Mediator {

    public static void main(String[] args) {
        FontDialogDirector director = new FontDialogDirector();
        director.showDialog();
        director.getOk().clicar();
    }

}
