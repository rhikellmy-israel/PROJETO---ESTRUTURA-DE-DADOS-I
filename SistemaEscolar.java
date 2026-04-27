import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SistemaEscolar {
    private int capacidade = 60;
    PilhaEstatica pilha = new PilhaEstatica(capacidade);
    PilhaEstatica pilha2 = new PilhaEstatica(capacidade);

    public SistemaEscolar() {

        int opcao = 0;

        do {
            String MenuEscolar = "-----Sistema Escolar de Alunos-----\n"
                    + "1. Cadastrar Alunos\n"
                    + "2. Calcular Situação\n"
                    + "3. Exibir Alunos Cadastrados\n"
                    + "4. Sair";

            String leitura = JOptionPane.showInputDialog(null, MenuEscolar, "Menu Escolar",
                    JOptionPane.QUESTION_MESSAGE);
            if (leitura == null)
                break;

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

        } while (opcao != 4);
    }

    private Double NotaValidade(JTextField campo, String nomeCampo) {

        while (true) {

            String texto = campo.getText().trim();

            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo " + nomeCampo + " está vazio. Preencha antes de continuar.");
                campo.requestFocus();
                return null;
            }

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
        }
    }

    public void CadastroAlunos() {

        int n = Integer.parseInt(
                JOptionPane.showInputDialog("Quantidade de alunos:"));

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
                    "Cadastro de Aluno" + (i + 1), // Título
                    JOptionPane.OK_CANCEL_OPTION // Definidos botões OK e Cancelar
            );

            if (result == JOptionPane.OK_OPTION) {

                Double matematica = NotaValidade(campoMat, "Matemática");
                Double portugues = NotaValidade(campoPort, "Português");
                Double historia = NotaValidade(campoHist, "História");
                Double geografia = NotaValidade(campoGeo, "Geografia");
                Double ciencias = NotaValidade(campoCien, "Ciências");

                if (matematica == null || portugues == null || historia == null ||
                        geografia == null || ciencias == null) {

                    i--; // volta o mesmo aluno
                    continue; // reabre o formulário
                }

                Alunos novoAluno = new Alunos(
                        campoNome.getText(),
                        matematica,
                        portugues,
                        historia,
                        geografia,
                        ciencias);
                pilha.push(novoAluno);
                pilha2.push(novoAluno);

                JOptionPane.showMessageDialog(null, "Aluno " + campoNome.getText() + " adicionado com sucesso!");
            }
        }

    }

    public void CalcularSituacao() {

        PilhaEstatica temp = new PilhaEstatica(capacidade);

        String resultado = "Nome\tMédia\tSituação\n";

        while (!pilha2.isEmpty()) {
            Alunos aluno = pilha2.pop();

            double media = (aluno.getNotaMatematica() + aluno.getNotaPortugues() +
                    aluno.getNotaHistoria() + aluno.getNotaGeografia() +
                    aluno.getNotaCiencias()) / 5;

            aluno.setMedia(media);

            boolean aprovado = aluno.getNotaMatematica() >= 6 &&
                    aluno.getNotaPortugues() >= 6 &&
                    aluno.getNotaHistoria() >= 6 &&
                    aluno.getNotaGeografia() >= 6 &&
                    aluno.getNotaCiencias() >= 6;

            if (aprovado) {
                aluno.setSituacao("Aprovado");
            } else {
                aluno.setSituacao("Reprovado");
            }

            resultado += String.format("%-20s %-10.2f %-10s\n",
                    aluno.getNome(),
                    aluno.getMedia(),
                    aluno.getSituacao());

            temp.push(aluno);
        }

        while (!temp.isEmpty()) {
            pilha2.push(temp.pop());
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public void ExibirAlunos() {

        String[] colunas = { "Nome", "Mat", "Port", "Hist", "Geo", "Cien", "Média", "Situação" };

        PilhaEstatica temp = new PilhaEstatica(capacidade);

        int tamanho = 0;

        // contar elementos
        while (!pilha.isEmpty()) {
            temp.push(pilha.pop());
            tamanho++;
        }

        Object[][] dados = new Object[tamanho][8];

        int i = 0;

        while (!temp.isEmpty()) {
            Alunos aluno = temp.pop();

            dados[i][0] = aluno.getNome();
            dados[i][1] = aluno.getNotaMatematica();
            dados[i][2] = aluno.getNotaPortugues();
            dados[i][3] = aluno.getNotaHistoria();
            dados[i][4] = aluno.getNotaGeografia();
            dados[i][5] = aluno.getNotaCiencias();
            dados[i][6] = aluno.getMedia();
            dados[i][7] = aluno.getSituacao();

            pilha.push(aluno);
            i++;
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        JOptionPane.showMessageDialog(null, scroll);
    }

    public static void main(String[] args) {
        new SistemaEscolar();
    }
}