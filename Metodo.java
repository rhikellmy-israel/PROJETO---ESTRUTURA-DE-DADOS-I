import java.util.Scanner;

public class Metodo {

    //Metodo para adicionar alunos

    public void CadastroAlunos(){
        int capacidade = 0;
        PilhaEstatica pilha = new PilhaEstatica(capacidade);
        PilhaEstatica pilha2 = new PilhaEstatica(capacidade);

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
                String Nome = campoNome.getText();
                Double NotaMatematica = Double.parseDouble(campoMat.getText());
                Double NotaPortugues = Double.parseDouble(campoPort.getText());
                Double NotaHistoria = Double.parseDouble(campoHist.getText());
                Double NotaGeografia = Double.parseDouble(campoGeo.getText());
                Double NotaCiencias = Double.parseDouble(campoCien.getText());

                Alunos novoAluno = new Alunos(Nome, NotaMatematica, NotaPortugues, NotaHistoria, NotaGeografia, NotaCiencias, Media);
                pilha.inserir(novoAluno);
                pilha2.inserir(novoAluno);
                JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
                capacidade++;
        }
        }else {
            JOptionPane.showMessageDialog(null, "Lista de alunos lotada!");
        }
    }

    //Método POP
    public Alunos pop(){
        if (topo == -1){
            return null;
        }
        Alunos aluno = pilha[topo];
        topo--;
        return aluno;
    }

    //Método para calcular a média e situação dos alunos
    public void CalcularSituacao(){
        if (topo == -1){
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
        }

        While (topo != -1){
            Alunos aluno = pop();

            String resultado = "";
        double Media = (aluno.getNotaMatematica() + aluno.getNotaPortugues() + aluno.getNotaHistoria() + aluno.getNotaGeografia() + aluno.getNotaCiencias()) / 5;

        String Situacao = "";

        if (aluno.getNotaMatematica() >= 6 && aluno.getNotaPortugues() >= 6 && aluno.getNotaHistoria() >= 6 && aluno.getNotaGeografia() >= 6 && aluno.getNotaCiencias() >= 6){
            Situacao = "Aprovado";
        } else if (aluno.getNotaMatematica() < 6 || aluno.getNotaPortugues() < 6 || aluno.getNotaHistoria() < 6 || aluno.getNotaGeografia() < 6 || aluno.getNotaCiencias() < 6 && Media == 6){ {
            Situacao = "Recuperação";
        } else {
            Situacao = "Reprovado";
        }

        resultado += "Nome: " + aluno.getNome() + "\n";
        resultado += "Média: " + Media + "\n";
        resultado += "Situação: " + Situacao + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}