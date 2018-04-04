package Model;

public class Estado {
    private int id;
    private String nome;
    private int pais;

    public Estado() {
    }

    public Estado(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estado(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
    
}
