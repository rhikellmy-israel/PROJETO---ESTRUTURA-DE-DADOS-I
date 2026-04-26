public class Alunos {
    private String nome;
    private double notaMatematica;
    private double notaPortugues;
    private double notaHistoria;
    private double notaGeografia;
    private double notaCiencias;
    private double media;
    private String situacao;

    public Alunos(String nome, double n1, double n2, double n3, double n4, double n5) {
        this.nome = nome;
        this.notaMatematica = n1;
        this.notaPortugues = n2;
        this.notaHistoria = n3;
        this.notaGeografia = n4;
        this.notaCiencias = n5;
    }

    public String getNome() { return nome; }
    public double getNotaMatematica() { return notaMatematica; }
    public double getNotaPortugues() { return notaPortugues; }
    public double getNotaHistoria() { return notaHistoria; }
    public double getNotaGeografia() { return notaGeografia; }
    public double getNotaCiencias() { return notaCiencias; }

    public double getMedia() { return media; }
    public String getSituacao() { return situacao; }

    public void setMedia(double media) { this.media = media; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
}