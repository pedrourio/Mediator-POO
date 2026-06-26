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
            double dx = cOutra.getX() - cRem.getX();
            double dy = cOutra.getY() - cRem.getY();
            double dist = Math.sqrt(dx * dx + dy * dy);

            if(dist < menorDist) {
                menorDist = dist;
                maisProximo = outra;
            }
        }
        if(maisProximo != null) maisProximo.receberMensagem(msg);
        
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
