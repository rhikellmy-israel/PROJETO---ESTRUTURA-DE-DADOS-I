import java.util.Scanner;

public class Metodo {

    //Metodo para adicionar alunos

    public void CadastroAlunos(){
        int capacidade = 0;
        System.out.println("Quantos alunos você deseja adicionar?");
        Scanner sc = new Scanner(System.in);
        capacidade = sc.nextInt();
        sc.nextLine(); 
        PilhaEstatica pilha = new PilhaEstatica(capacidade);
        // Limpar o buffer

        for (int i = 0; i < capacidade; i++) {
            System.out.println("Digite o nome do aluno:");
            String nome = sc.nextLine();

            System.out.println("Digite a Nota de Matemática de " + Nome);
            Double NotaMatematica = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Português de " + Nome);
            Double NotaPortugues = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de História de " + Nome);
            Double NotaHistoria = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Geografia de " + Nome);
            Double NotaGeografia = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Ciencias de " + Nome);
            Double NotaCiencias = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer
            System.out.println(""); // Pular linha para melhor visualização


            Alunos novoAluno = new Alunos(Nome, NotaMatematica, NotaPortugues, NotaHistoria, NotaGeografia, NotaCiencias);
            pilha.inserir(novoAluno);

            System.out.println("Aluno " + novoAluno.getNome() + " adicionado com sucesso!");
        }
    }
}