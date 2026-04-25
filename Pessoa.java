import javax.swing.JOptionPane;

public class Pessoa {

    private String nome;
    private int idade;
    private String telefone;

    // Construtor vazio
    public Pessoa() {
    }

    // Construtor com parâmetros atualizado
    public Pessoa(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
