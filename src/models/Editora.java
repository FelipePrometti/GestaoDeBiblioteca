package models;

public class Editora {
    private int id;
    private String nome;
    private String endereco;

    public Editora(int id, String nome, String endereco){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        this.nome = nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco
    }
}
