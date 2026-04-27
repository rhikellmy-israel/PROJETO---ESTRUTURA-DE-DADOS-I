import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SistemaEscolar {        
    private int capacidade = 0;
    PilhaEstatica pilha = new PilhaEstatica(capacidade);
    PilhaEstatica pilha2 = new PilhaEstatica(capacidade);


    public SistemaEscolar(){


        int opcao=0;

        do{
            String MenuEscolar = "-----Sistema Escolar de Alunos-----\n"
                    + "1. Cadastrar Alunos\n"
                    + "2. Calcular Situação\n"
                    +"3. Exibir Alunos Cadastrados\n"
                    + "4. Sair";

            String leitura = JOptionPane.showInputDialog(null, MenuEscolar, "Menu Escolar", JOptionPane.QUESTION_MESSAGE);
            if (leitura == null) break;

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

    private Double NotaValidade(JTextField campo, String nomeCampo) {
    String texto = campo.getText().trim();
    if (texto.isEmpty()) {
        JOptionPane.showMessageDialog(null,
                "O campo " + nomeCampo + " está vazio. Preencha antes de continuar.");
        campo.requestFocus();
        return null;
    }

    try {
        double nota = Double.parseDouble(texto);

        if (nota >= 0 && nota <= 10) {
            return nota;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nota inválida para " + nomeCampo + ". Deve ser entre 0 e 10.");

            campo.setText("");
            campo.requestFocus();
            return null;
      }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null,
                "Digite um número válido para " + nomeCampo + ".");

        campo.setText("");
        campo.requestFocus();
        return null;
    }
}
            
    public void CadastroAlunos(){

            int n = Integer.parseInt(
                    JOptionPane.showInputDialog("Quantidade de alunos:")
            );
        
            for (int i = 0; i < n; i++) {
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
                "Cadastro de Aluno" + (i+1), // Título
                JOptionPane.OK_CANCEL_OPTION  // Definidos botões OK e Cancelar
            );

            if (result == JOptionPane.OK_OPTION) {
                if (campoNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "O campo Nome está vazio. Preencha antes de continuar.");
                    i--;
                    continue;
                }

                Double matematica = NotaValidade(campoMat, "Matemática");
                Double portugues = NotaValidade(campoPort, "Português");
                Double historia = NotaValidade(campoHist, "História");
                Double geografia = NotaValidade(campoGeo, "Geografia");
                Double ciencias = NotaValidade(campoCien, "Ciências");

                if (matematica == null || portugues == null || historia == null || geografia == null || ciencias == null) {
                    i--;
                    continue;
                }

                Alunos novoAluno = new Alunos(
                        campoNome.getText(),
                        matematica,
                        portugues,
                        historia,
                        geografia,
                        ciencias
                );
                pilha.push(novoAluno);
                pilha2.push(novoAluno);

                JOptionPane.showMessageDialog(null, "Aluno " + campoNome.getText() + " adicionado com sucesso!");
            } else {
                return;
            }

        
    }

        }






    public void CalcularSituacao(){

        PilhaEstatica temp = new PilhaEstatica(60);
        while(!pilha2.isEmpty()){
        Alunos novoAluno = pilha2.pop();

        double media = (novoAluno.getNotaMatematica()+novoAluno.getNotaPortugues()+
                        novoAluno.getNotaHistoria()+novoAluno.getNotaGeografia()+
                        novoAluno.getNotaCiencias())/5;

        novoAluno.setMedia(media);

        boolean Situacao =novoAluno.getNotaMatematica() >= 6 && novoAluno.getNotaPortugues() >= 6 
                        && novoAluno.getNotaHistoria() >= 6 && novoAluno.getNotaGeografia() >= 6 
                        && novoAluno.getNotaCiencias() >= 6;

        if (Situacao) {
            novoAluno.setSituacao("Aprovado");
        } else {
            novoAluno.setSituacao("Reprovado");
        }

        temp.push(novoAluno);
        

            while(!pilha.isEmpty()){
            pilha2.push(temp.pop());
             }

        }
    }
    

    public void ExibirAlunos(){

        String[] colunas = {"Nome", "Nota Matemática", "Nota Português", "Nota História", "Nota Geografia", "Nota Ciências", "Média", "Situação"};
        Object[][] dados = new Object[capacidade][8];

        PilhaEstatica temp = new PilhaEstatica(60);


        for(int i =0; i<capacidade; i++){

            Alunos novoAlunos = pilha.pop();


            dados[i][0] = novoAlunos.getNome();
            dados[i][1] = novoAlunos.getNotaMatematica();
            dados[i][2] = novoAlunos.getNotaPortugues();
            dados[i][3] = novoAlunos.getNotaHistoria();
            dados[i][4] = novoAlunos.getNotaGeografia();
            dados[i][5] = novoAlunos.getNotaCiencias();
            dados[i][6] = novoAlunos.getMedia();
            dados[i][7] = novoAlunos.getSituacao();
        } 
        
        JTable sistema = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(sistema);
        JOptionPane.showMessageDialog(null, scroll, "Sistema Escolar de Alunos", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void main(String[] args) {
        new SistemaEscolar();
    }
}