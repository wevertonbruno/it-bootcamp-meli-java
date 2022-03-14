package Domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CircuitoBase {
    private List<Inscricao> inscricoes = new ArrayList<>();

    public void addInscricao(Inscricao inscricao){ this.inscricoes.add(inscricao); }
    public List<Inscricao> getInscricoes(){ return this.inscricoes; }
}
