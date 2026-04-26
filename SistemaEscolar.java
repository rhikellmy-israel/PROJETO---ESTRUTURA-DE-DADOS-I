import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SistemaEscolar {

    private Alunos[] capacidade= new Alunos[60];
    private int capacidade=0;

    public SistemaEscolar(){
        int opcao=0;
        do{
            String MenuEscolar = "-----Sistema Escolar de Alunos-----\n"
                    + "1. Cadastrar Alunos\n"
                    + "2. Calcular Situação\n"
                    +"3. Exibir Alunos Cadastrados\n"
                    + "4. Sair";

            String leitura = JOptionPane.showInputDialog(null, MenuEscolar, "Menu Escolar", JOptionPane.QUESTION_MESSAGE);
            if (leitura == null) {
                break;
            }
            opcao = Integer.parseInt(leitura);

            switch (opcao) {
                case 1:
                    CadastroAlunos();
                    break;
                case 2:
                    CalcularSituacao();
                    break;
                case 3:
                    ExibirAlunos();
                    break;
            }

    }while (opcao != 4);
    }

    public void ExibirAlunos(){

        String[] colunas = {"Nome", "Nota Matemática", "Nota Português", "Nota História", "Nota Geografia", "Nota Ciências", "Média", "Situação"};
        Object[][] dados = new Object[capacidade][8];

        for(int i =0; i<capacidade; i++){
            dados[i][0] = capacidade[i].getNome();
            dados[i][1] = capacidade[i].pilha.getNotaMatematica();
            dados[i][2] = capacidade[i].pilha.getNotaPortugues();
            dados[i][3] = capacidade[i].pilha.getNotaHistoria();
            dados[i][4] = capacidade[i].pilha.getNotaGeografia();
            dados[i][5] = capacidade[i].pilha.getNotaCiencias();
            dados[i][6] = capacidade[i].pilha.getMedia();
            dados[i][7] = capacidade[i].pilha.getSituacao();
        } 
        
        JTable sistema = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(sistema);
        JOptionPane.showMessageDialog(null, scroll, "Sistema Escolar de Alunos", JOptionPane.INFORMATION_MESSAGE);





    }
    public void CalcularSituacao(){


    }










   








    public static void main(String[] args) {
        Alunos aluno = new Alunos(null, null, null, null, null, null);
        Metodo metodo = new Metodo();
        metodo.CadastroAlunos();


    
    }
}
