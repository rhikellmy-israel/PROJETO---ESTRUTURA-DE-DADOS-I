public class Alunos {
    private String Nome;
    private Double NotaMatematica;
    private Double NotaPortugues;
    private Double NotaHistoria;
    private Double NotaGeografia;
    private Double NotaCiencias;
    private Double Media;
    private String Situacao;


    public Alunos(String Nome, Double NotaMatematica, Double NotaPortugues, Double NotaHistoria, Double NotaGeografia, Double NotaCiencias) {
        this.Nome = Nome;
        this.NotaMatematica = NotaMatematica;
        this.NotaPortugues = NotaPortugues;
        this.NotaHistoria = NotaHistoria;
        this.NotaGeografia = NotaGeografia;
        this.NotaCiencias = NotaCiencias;
    }

    public String getNome(){
        return Nome;
    }
    public Double getNotaDeMatematica() {
        return NotaMatematica;
    }
    public Double getNotaDePortugues() {
        return NotaPortugues;
    }
    public Double getNotaDeHistoria() {
        return NotaHistoria;
    }
    public Double getNotaDeGeografia() {
        return NotaGeografia;
    }
    public Double getNotaDeCiencias() {
        return NotaCiencias;
    }
    public Double getMedia(){
        return Media;
    }
    public String getSituacao(){
        return Situacao;
    }


}

