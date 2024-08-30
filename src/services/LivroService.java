package services;

import models.Livro;
import models.Autor;
import repository.LivroRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void buscarLivrosPorGeneroEExibir(String genero) {
        livroRepository.listarTodosOsLivros().stream()
                .filter(livro -> livro.getGenero().equalsIgnoreCase(genero))
                .forEach(livro -> System.out.println(livro));
    }

    public List<Livro> buscarLivrosPorAutor(String autorNome) {
        return livroRepository.listarTodosOsLivros().stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autorNome))
                .collect(Collectors.toList());
    }

    public List<Livro> buscarLivrosComAutorNaLista(List<Autor> autores) {
        return livroRepository.listarTodosOsLivros().stream()
                .filter(livro -> autores.stream()
                        .anyMatch(autor -> autor.getNome().equalsIgnoreCase(livro.getAutor())))
                .collect(Collectors.toList());
    }
}
