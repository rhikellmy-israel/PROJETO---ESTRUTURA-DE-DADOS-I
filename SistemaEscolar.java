import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SistemaEscolar {        
    private int capacidade = 0;
    PilhaEstatica pilha = new PilhaEstatica(60);
    PilhaEstatica pilha2 = new PilhaEstatica(60);
    private Alunos[] alunos= new Alunos[60];

    

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

    public void CadastroAlunos(){


        if (capacidade < 60) {
            JTextField campoNome = new JTextField();
            JTextField campoMat = new JTextField();
            JTextField campoPort = new JTextField();
            JTextField campoHist = new JTextField();
            JTextField campoGeo = new JTextField();
            JTextField campoCien = new JTextField();

            Object[] formulario = {
                "Nome:", campoNome,
                "Nota de Matemática:", campoMat,
                "Nota de Português:", campoPort,
                "Nota de História:", campoHist,
                "Nota de Geografia:", campoGeo,
                "Nota de Ciências:", campoCien
            };

            int result = JOptionPane.showConfirmDialog(
                null, // Centraliza
                formulario, // Campos
                "Cadastro de Aluno",  // Título
                JOptionPane.OK_CANCEL_OPTION  // Definidos botões OK e Cancelar
            );

            if (result == JOptionPane.OK_OPTION) {
                Alunos novoAluno = new Alunos(
                    campoNome.getText(),
                    Double.parseDouble(campoMat.getText()),
                    Double.parseDouble(campoPort.getText()),
                    Double.parseDouble(campoHist.getText()),
                    Double.parseDouble(campoGeo.getText()),
                    Double.parseDouble(campoCien.getText())
                );
                pilha.push(novoAluno);
            
                JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
                capacidade++;
        }
        }else {
            JOptionPane.showMessageDialog(null, "Lista de alunos lotada!");
        }
    }

     public void recarregarPilha2(){

        PilhaEstatica temp = new PilhaEstatica(60);

        while(!pilha.vazia()){
            temp.push(pilha.pop());
        }

        while(!temp.vazia()){
            Alunos a = temp.pop();
            pilha.push(a);
            pilha2.push(a);
        }
    }

    

    //Método para calcular a média e situação dos alunos
    public void CalcularSituacao(){

        recarregarPilha2();
        
        for(int i=0;i<capacidade;i++){
            Alunos a = alunos[i];

            double media = (a.getNotaMatematica()+a.getNotaPortugues()+
                            a.getNotaHistoria()+a.getNotaGeografia()+
                            a.getNotaCiencias())/5;

            a.setMedia(media);

        if (a.getNotaMatematica() >= 6 && a.getNotaPortugues() >= 6 && a.getNotaHistoria() >= 6 && a.getNotaGeografia() >= 6 && a.getNotaCiencias() >= 6){
            a.setSituacao("Aprovado");
        } else if (a.getNotaMatematica() < 6 || a.getNotaPortugues() < 6 || a.getNotaHistoria() < 6 || a.getNotaGeografia() < 6 || a.getNotaCiencias() < 6 && a.getMedia() == 6){ 
            a.setSituacao("Recuperação");
        } else {
            a.setSituacao("Reprovado");
        }
        }

        JOptionPane.showMessageDialog(null,"Cálculo realizado!");
    }



    public void ExibirAlunos(){

        String[] colunas = {"Nome", "Nota Matemática", "Nota Português", "Nota História", "Nota Geografia", "Nota Ciências", "Média", "Situação"};
        Object[][] dados = new Object[capacidade][8];

        for(int i =0; i<capacidade; i++){
            dados[i][0] = alunos[i].getNome();
            dados[i][1] = alunos[i].getNotaMatematica();
            dados[i][2] = alunos[i].getNotaPortugues();
            dados[i][3] = alunos[i].getNotaHistoria();
            dados[i][4] = alunos[i].getNotaGeografia();
            dados[i][5] = alunos[i].getNotaCiencias();
            dados[i][6] = alunos[i].getMedia();
            dados[i][7] = alunos[i].getSituacao();
        } 
        
        JTable sistema = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(sistema);
        JOptionPane.showMessageDialog(null, scroll, "Sistema Escolar de Alunos", JOptionPane.INFORMATION_MESSAGE);





    }


    public static void main(String[] args) {
        new SistemaEscolar();
    }
}
