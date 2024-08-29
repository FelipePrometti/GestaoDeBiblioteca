package repository;

import models.Livro;

import java.sql.SQLException;
import java.util.List;

// usamos uma interface pra definir que metodos teríamos que implementar

public interface LivroRepositoryInterface {

    void salvarLivro(Livro livro) throws SQLException;;

    Livro buscarLivroPorId(int id) throws SQLException;;

    void excluirLivro(int id) throws SQLException;;

    List<Livro> listarTodosOsLivros() throws SQLException;;
}
