package components;

import javax.swing.JLabel;
import core.Widget;
import core.DialogDirector;

public class Botao2 extends JLabel implements Widget{
    private DialogDirector director;
    String nome;

    public Botao2(DialogDirector director, String nome){
        super(nome);
        this.nome = nome;
        this.director = director;
    }

    public void mudarTexto(String texto){
        if(this.getText().equals("Texto Mudado")){
            texto = "Texto generico";
        }
        this.setText(texto);
    }

    @Override
    public void changed(){}

}
