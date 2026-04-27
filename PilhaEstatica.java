public class PilhaEstatica {

    private Alunos[] pilha;
    private int topo;

    public PilhaEstatica(int capacidade) {
        pilha = new Alunos[capacidade];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == pilha.length - 1;
    }

    public void push(Alunos a) {
        if (!cheia()) {
            pilha[++topo] = a;
        }
    }

    public Alunos pop() {
        if (isEmpty()) return null;
        return pilha[topo--];
    }
}