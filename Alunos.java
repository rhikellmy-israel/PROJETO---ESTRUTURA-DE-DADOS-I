public class Alunos {

    private String nome;
    private double notaMatematica;
    private double notaPortugues;
    private double notaHistoria;
    private double notaGeografia;
    private double notaCiencias;

    private double media;
    private String situacao;

    public Alunos(String nome, double mat, double port, double hist, double geo, double cien) {
        this.nome = nome;
        this.notaMatematica = mat;
        this.notaPortugues = port;
        this.notaHistoria = hist;
        this.notaGeografia = geo;
        this.notaCiencias = cien;
    }

    public String getNome() { 
        return nome; }
    public double getNotaMatematica() { 
        return notaMatematica; }
    public double getNotaPortugues() { 
        return notaPortugues; }
    public double getNotaHistoria() { 
        return notaHistoria; }
    public double getNotaGeografia() { 
        return notaGeografia; }
    public double getNotaCiencias() { 
        return notaCiencias; }

    public double getMedia() { 
        return media; }
    public String getSituacao() { 
        return situacao; }

    public void setMedia(double media) { 
        this.media = media; }
    public void setSituacao(String situacao) { 
        this.situacao = situacao; }

}
