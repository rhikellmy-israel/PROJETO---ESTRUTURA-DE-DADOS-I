public class PilhaEstatica{
    String vet[];
    int topo;


    public PilhaEstatica(int tamanho){
        this.vet = new String[tamanho]; //alocando espaco na memoria pora os elementos
        this.topo = -1;
    }

    boolean cheia(){//veerificar se a pilha esta cheia
        return vet.length == topo; //verificar se meu tamanho do vetor é igual ao topo
    }

    boolean inserir(String valor){
        if (cheia()){
            return false;
        }
        vet[topo] = valor; //passa a receber o valor como parametro
        topo++; //o topo vai para o proximo elemnto, incrmentando meu topo
        return true; // conseguindo inserir o elemento
    }
}