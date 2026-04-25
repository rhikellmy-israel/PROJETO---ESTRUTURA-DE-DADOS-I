//import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Agenda {

    // Atributos de instância (compartilhados entre os métodos)
    private Pessoa[] listaPessoas = new Pessoa[20];
    private int totalCadastrado = 0;

    // Construtor: contém a lógica principal do menu
    public Agenda() {
        totalCadastrado = cargaInicial(listaPessoas);
        bubbleSort(listaPessoas, totalCadastrado);

        int opcao = 0;
        do {
            String menu = "--- AGENDA ---\n"
                    + "Cadastrados: " + totalCadastrado + "/20\n\n"
                    + "1. Acrescentar nova pessoa\n"
                    + "2. Exibir agenda (Lista)\n"
                    + "3. Exibir agenda (Grid)\n"
                    + "4. Sair";

            // O Java cria o OK e Cancelar sozinho aqui
            String leitura = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.ERROR_MESSAGE);

            // Se o usuário clicar em "Cancelar" ou no "X", a variável 'leitura' recebe null
            if (leitura == null) break; 

            // Se ele clicar em OK, o valor digitado vai para 'opcao'
            opcao = Integer.parseInt(leitura);


            switch (opcao) {
                case 1:
                    adicionarPessoa();
                    break;
                case 2:
                    exibirAgenda();
                    break;
                case 3:
                    exibirAgendaGrid();
                    break;
            }
        } while (opcao != 4);
    }

    // Método separado para entrada de dados (Case 1)
    public void adicionarPessoa() {
        if (totalCadastrado < 20) {
            JTextField campoNome = new JTextField();
            JTextField campoIdade = new JTextField();
            JTextField campoTelefone = new JTextField();
            Object[] formulario = {"Nome:", campoNome, "Idade:", campoIdade, "Telefone:", campoTelefone};

            int result = JOptionPane.showConfirmDialog(
                null, // Componente pai (null para centralizar na tela)
                formulario, // O array com os campos de texto e rótulos
                "Novo Cadastro",  // Título da janela
                JOptionPane.OK_CANCEL_OPTION  // Definidos botões OK e Cancelar
            );

            if (result == JOptionPane.OK_OPTION) {
                Pessoa p = new Pessoa(campoNome.getText(), Integer.parseInt(campoIdade.getText()), campoTelefone.getText());
                listaPessoas[totalCadastrado] = p;
                totalCadastrado++;
                bubbleSort(listaPessoas, totalCadastrado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agenda lotada!");
        }
    }

    // Método separado para exibição (Case 2)
    public void exibirAgenda() {
        String relatorio = "--- CONTATOS ---\n";
        for (int i = 0; i < totalCadastrado; i++) {
            relatorio += (i + 1) + ". " + listaPessoas[i].getNome() + " | Idade: " + listaPessoas[i].getIdade() + " | Tel: " + listaPessoas[i].getTelefone() + "\n";
        }
        JOptionPane.showMessageDialog(null, relatorio);
    }


    public void exibirAgendaGrid() {
        // 1. Definir os cabeçalhos das colunas
        String[] colunas = {"Nome", "Idade", "Telefone"};

        // 2. Criar a matriz de dados (linhas x colunas)
        Object[][] dados = new Object[totalCadastrado][3];

        for (int i = 0; i < totalCadastrado; i++) {
            dados[i][0] = listaPessoas[i].getNome();
            dados[i][1] = listaPessoas[i].getIdade();
            dados[i][2] = listaPessoas[i].getTelefone();
        }

        // 3. Criar a tabela com os dados
        JTable tabela = new JTable(dados, colunas);
        
        // 4. Colocar a tabela dentro de um JScrollPane para aparecer o cabeçalho
        JScrollPane scroll = new JScrollPane(tabela);

        // 5. Exibir tudo no JOptionPane
        JOptionPane.showMessageDialog(null, scroll, "Agenda de Contatos", JOptionPane.PLAIN_MESSAGE);
    }

    public void bubbleSort(Pessoa[] vetor, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vetor[j].getNome().compareToIgnoreCase(vetor[j + 1].getNome()) > 0) {
                    Pessoa temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    public int cargaInicial(Pessoa[] lista) {
        String[] nomes = {"Julia", "Bruno", "Ana", "Zeca", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Carlos"};
        for (int i = 0; i < 10; i++) {
            lista[i] = new Pessoa(nomes[i], 20 + i, "9999-" + (1000 + i));
        }
        return 10;
    }

    // Main apenas instancia o objeto
    public static void main(String[] args) {
        new Agenda();
    }
}
