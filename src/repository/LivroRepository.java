package repository;

import dao.LivroDAO;
import models.Livro;
import java.sql.SQLException;
import java.util.List;

public class LivroRepository implements LivroRepositoryInterface {

    private LivroDAO livroDAO;

    public LivroRepository() {
        this.livroDAO = new LivroDAO();
    }

    @Override
    public void salvarLivro(Livro livro) throws SQLException {
        if (livro.getId() == 0) {
            livroDAO.cadastrarLivro(livro);
        } else {
            livroDAO.alterarLivro(livro);
        }
    }

    @Override
    public Livro buscarLivroPorId(int id) throws SQLException {
        return livroDAO.buscarPorId(id);
    }

    @Override
    public void excluirLivro(int id) throws SQLException {
        livroDAO.excluirLivro(id);
    }

    @Override
    public List<Livro> listarTodosOsLivros() throws SQLException {
        return livroDAO.listarTodos();
    }
}
