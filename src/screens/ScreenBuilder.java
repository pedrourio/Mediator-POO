package screens;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.*;
import core.Pessoa;


public class ScreenBuilder {
    public static void main(String[] args){
        ConcreteDialogDirector mediador = new ConcreteDialogDirector(); 
        showDialog(mediador);
    }

    static void showDialog(ConcreteDialogDirector mediador){
        JFrame frame = new JFrame("Conversa");
        frame.setLayout(new FlowLayout());
                                                              
        Pessoa pessoa1 = new ConcretePessoa(mediador, "Claudio");
        Pessoa pessoa2 = new ConcretePessoa(mediador, "Guilherme");
        Pessoa pessoa3 = new ConcretePessoa(mediador, "Ruan");
        Pessoa pessoa4 = new ConcretePessoa(mediador, "Victor");
        Pessoa pessoa5 = new ConcretePessoa(mediador, "Pedro");
        Pessoa pessoa6 = new ConcretePessoa(mediador, "Alexandre");

        mediador.addPessoa(pessoa6);
        mediador.addPessoa(pessoa5);
        mediador.addPessoa(pessoa4);
        mediador.addPessoa(pessoa3);
        mediador.addPessoa(pessoa2);
        mediador.addPessoa(pessoa1);

        
        for(ConcretePessoa pessoa : mediador.pessoas){

            pessoa.btn1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    pessoa.falarMaisProximo(pessoa.nome + " está dizendo oi para o mais proximo!" );
                }
            });

            pessoa.btn2.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    pessoa.falarGeral(pessoa.nome + " está dizendo oi para todos!");
                }
            });

            frame.add(pessoa);
        }

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
