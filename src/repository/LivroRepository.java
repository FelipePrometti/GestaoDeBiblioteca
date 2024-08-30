package repository;

import models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroRepository implements LivroRepositoryInterface {

    private List<Livro> livros;

    public LivroRepository() {
        this.livros = new ArrayList<>();
    }

    @Override
    public void salvarLivro(Livro livro) {
        Optional<Livro> existingLivro = livros.stream()
                .filter(l -> l.getId() == livro.getId())
                .findFirst();
        if (existingLivro.isPresent()) {
            livros.remove(existingLivro.get());
            livros.add(livro);
        } else {
            livros.add(livro);
        }
    }

    @Override
    public Livro buscarLivroPorId(int id) {
        return livros.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void excluirLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }

    @Override
    public List<Livro> listarTodosOsLivros() {
        return new ArrayList<>(livros);
    }
}
