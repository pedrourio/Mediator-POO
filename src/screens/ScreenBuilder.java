package screens;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.*;


public class ScreenBuilder {
    public static void main(String[] args){
        FontDialogDirector mediador = new FontDialogDirector(); 
        showDialog(mediador);
    }

    static void showDialog(FontDialogDirector mediador){
        JFrame frame = new JFrame("Formulario");
        frame.setLayout(new FlowLayout());
                                                              
        Botao1 botao1 = new Botao1(mediador, "Mudar fonte");
        Botao2 botao2 = new Botao2(mediador, "Texto generico");

        mediador.setBotao1(botao1);
        mediador.setBotao2(botao2);

        botao1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                botao1.changed();
            }
        });

        frame.add(botao1);
        frame.add(botao2);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
