package core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pedro
 * @author becker
 */

public abstract class DialogDirector {
    List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> getPessoas(){
        return this.pessoas;
    }
    public abstract void acharProximo(String msg, Pessoa pessoa);

    public abstract void broadcast(String msg);

    public abstract void addPessoa(Pessoa pessoa);
}


