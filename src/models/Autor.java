//Criamos essa classe mas não foi solicitada a utilização dela na CP

package models;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int id;
    private String nome;
    private List<Livro> livros;

    public Autor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.livros = new ArrayList<>();
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}

