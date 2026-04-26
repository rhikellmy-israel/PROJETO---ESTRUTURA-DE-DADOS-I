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

            System.out.println("Digite a Nota de Matemática " );
            Double NotaMatematica = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Português ");
            Double NotaPortugues = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de História " );
            Double NotaHistoria = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Geografia " );
            Double NotaGeografia = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Ciencias " );
            Double NotaCiencias = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer
            System.out.println(""); // Pula uma linha

            Alunos novoAluno = new Alunos(nome, NotaMatematica, NotaPortugues, NotaHistoria, NotaGeografia, NotaCiencias);
            pilha.inserir(novoAluno);

            System.out.println("Aluno " + novoAluno.getNome() + " adicionado com sucesso!");
        }
    }
}