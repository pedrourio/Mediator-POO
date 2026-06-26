package screens;

import java.awt.Component;
import core.DialogDirector;
import core.Pessoa;
import components.*;


public class ConcreteDialogDirector extends DialogDirector{
    private int n = 0;

    @Override
    public void acharProximo(String msg, Pessoa remetente){
        Component cRem = (Component) remetente;
        Pessoa maisProximo = null;
        double menorDist = Double.MAX_VALUE;

        for(Pessoa outra : pessoas) {
            if (outra == remetente) continue;
            Component cOutra = (Component) outra;
            double dx = cOutra.getX() - c.Rem.getX();
            double dy = cOutra.getY() - cRem.getY();

            if(dis < menorDist) {
                menorDist = dist;
                maisProximo = outra;
            }
        }
        if(maisProximo != null) maisProximo.receberMensagem(msg);
        pessoa.receberMensagem(msg);
    }

    @Override
    public void broadcast(String msg){
        for(Pessoa pessoa : this.pessoas){
            pessoa.receberMensagem(msg);
        }
    }

    @Override
    public void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    
}
