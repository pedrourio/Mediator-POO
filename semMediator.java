import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class semMediator {

    public static void main(String[] args) {
        showDialog();
    }

    static void showDialog() {
        JFrame frame = new JFrame("Conversa (sem mediador)");
        frame.setLayout(new FlowLayout());

        // Sem mediador: a propria lista compartilhada e o que liga as pessoas.
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Claudio",   pessoas));
        pessoas.add(new Pessoa("Guilherme", pessoas));
        pessoas.add(new Pessoa("Ruan",      pessoas));
        pessoas.add(new Pessoa("Victor",    pessoas));
        pessoas.add(new Pessoa("Pedro",     pessoas));
        pessoas.add(new Pessoa("Alexandre", pessoas));

        for (Pessoa pessoa : pessoas) {

            pessoa.btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pessoa.falarMaisProximo(pessoa.nome + " está dizendo oi para o mais proximo!");
                }
            });

            pessoa.btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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

/*
 * Sem mediador a Pessoa guarda a lista de todas as outras pessoas e faz
 * sozinha o trabalho que antes era do ConcreteDialogDirector.
 */
class Pessoa extends JPanel {
    String nome;
    List<Pessoa> todas;
    JButton btn1 = new JButton("Mandar mensagem para o mais proximo");
    JButton btn2 = new JButton("Mandar mensagem para todos");

    Pessoa(String nome, List<Pessoa> todas) {
        this.nome = nome;
        this.todas = todas;
        add(btn1);
        add(btn2);
    }

    // Antes: director.acharProximo(msg, this).
    // Agora a propria Pessoa percorre as outras e acha a mais proxima.
    void falarMaisProximo(String msg) {
        Pessoa maisProximo = null;
        double menorDist = Double.MAX_VALUE;

        for (Pessoa outra : todas) {
            if (outra == this) continue;
            double dx = outra.getX() - this.getX();
            double dy = outra.getY() - this.getY();
            double dist = Math.sqrt(dx * dx + dy * dy);

            if (dist < menorDist) {
                menorDist = dist;
                maisProximo = outra;
            }
        }
        if (maisProximo != null) maisProximo.receberMensagem(msg);
        this.receberMensagem(msg);
    }

    // Antes: director.broadcast(msg).
    // Agora a Pessoa fala direto com todas as outras.
    void falarGeral(String msg) {
        for (Pessoa pessoa : todas) {
            pessoa.receberMensagem(msg);
        }
    }

    void receberMensagem(String msg) {
        System.out.println(this.nome + " recebeu a mensagem: " + msg);
    }
}
