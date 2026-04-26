import java.util.Scanner;

public class Metodo() {
    Scanner sc = new Scanner(System.in);

    //Metodo para adicionar alunos

    public void push(Alunos aluno){
        System.out.println("Quantos alunos você deseja adicionar?");
        int capacidade = sc.nextInt();");
        sc.nextLine(); // Limpar o buffer

        for (int i = 0; i < capacidade; i++) {
            System.out.println("Digite o nome do aluno:");
            String nome = sc.nextLine();

            System.out.println("Digite a Nota de Matemática do" + nome + ":");
            Double NotaMatematica = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Português do" + nome + ":");
            Double NotaPortugues = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de História do" + nome + ":");
            Double NotaHistoria = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Geografia do" + nome + ":");
            Double NotaGeografia = sc.nextDouble();
            sc.nextLine(); // Limpar o buffer

            System.out.println("Digite a Nota de Ciencias do" + nome + ":");
            Double NotaCiencias = sc.nextDouble();

            Alunos novoAluno = new Alunos(nome, NotaMatematica, NotaPortugues, NotaHistoria, NotaGeografia, NotaCiencias);
            Alunos.add(novoAluno);
        }
    }
}
