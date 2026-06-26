package components;

import javax.swing.JButton;
import javax.swing.JPanel;
import core.Pessoa;
import core.DialogDirector;

public class ConcretePessoa extends JPanel implements Pessoa{
    private DialogDirector director;
    String nome;
    JButton btn1 = new JButton("Mandar mensagem para o mais proximo");
    JButton btn2 = new JButton("Mandar mensagem para todos");

    public ConcretePessoa(DialogDirector director, String nome){
        this.nome = nome;
        this.director = director;
    }

    @Override
    public void falarMaisProximo(String msg){
        director.acharProximo(msg, this);
    }

    @Override
    public void falarGeral(String msg){
        director.broadcast(msg);
    }

    @Override
    public void receberMensagem(String msg){
        System.out.println(this.nome + " recebeu a mensagem: " + msg);
    }

}
