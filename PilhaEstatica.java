public class PilhaEstatica {
    private Alunos[] pilha;
    private int topo;

    public PilhaEstatica(int capacidade){
        pilha = new Alunos[capacidade];
        topo = -1;
    }

    public boolean cheia(){
        return topo == pilha.length - 1;
    }

    public boolean vazia(){
        return topo == -1;
    }

    public boolean push(Alunos aluno){
        if (cheia()) return false;
        pilha[++topo] = aluno;
        return true;
    }

    public Alunos pop(){
        if (vazia()) return null;
        return pilha[topo--];
    }

    public Alunos[] getPilha(){
        return pilha;
    }

    public int getTopo(){
        return topo;
    }
}