import java.util.Scanner;

public class PilhaEstatica{
    Alunos pilha[];
    String vet[];
    int topo;


    public PilhaEstatica(int capacidade){
        this.pilha = new Alunos[capacidade];
        this.topo = -1;
    }

    boolean cheia(){//veerificar se a pilha esta cheia
        return pilha.length == topo; //verificar se meu tamanho do pilha é igual ao topo
    }

    boolean inserir(Alunos aluno){
        if (cheia()){
            return false;
        }
        pilha[topo] = aluno; //passa a receber o valor como parametro
        topo++; //o topo vai para o proximo elemnto, incrmentando meu topo
        return true; // conseguindo inserir o elemento
    }

    //Metodo para adicionar alunos

}