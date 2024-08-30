package repository;

import models.Livro;

import java.sql.SQLException;
import java.util.List;

// usamos uma interface pra definir que metodos teríamos que implementar

public interface LivroRepositoryInterface {

    void salvarLivro(Livro livro) ;

    Livro buscarLivroPorId(int id) ;

    void excluirLivro(int id) ;

    List<Livro> listarTodosOsLivros() ;
}
