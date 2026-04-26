import java.util.Scanner;

public class PilhaEstatica {
    Alunos pilha[];
    int topo;

    public PilhaEstatica(int capacidade){
        this.pilha = new Alunos[capacidade];
        this.topo = -1;
    }

    boolean cheia(){
        return topo == pilha.length - 1;
    }

    boolean inserir(Alunos aluno){
        if (cheia()){
            return false;
        }
        topo++;
        pilha[topo] = aluno;
        return true;
    }
    public String getpilha(){
        return java.util.Arrays.toString(pilha);
    }
}