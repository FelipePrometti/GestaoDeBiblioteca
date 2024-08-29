package dao;

import models.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection conexao;

    public void cadastrarLivro(Livro livro) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "INSERT INTO tbl_livro (ID_LIVRO, TITULO, AUTOR, ANO, CATEGORIA, GENERO, EDITORA) VALUES (?, ?, ?, ?, ?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, livro.getId());
            comandoSQL.setString(2, livro.getTitulo());
            comandoSQL.setString(3, livro.getAutor());
            comandoSQL.setInt(4, livro.getAno());
            comandoSQL.setString(5, livro.getCategoria());
            comandoSQL.setString(6, livro.getGenero());
            comandoSQL.setString(7, livro.getEditora());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Livro buscarPorId(int id) throws SQLException {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        Livro livro = null;
        try {
            String sql = "SELECT * FROM tbl_livro WHERE ID_LIVRO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            ResultSet rs = comandoSQL.executeQuery();
            if (rs.next()) {
                livro = new Livro(
                        rs.getInt("ID_LIVRO"),
                        rs.getString("TITULO"),
                        rs.getString("AUTOR"),
                        rs.getInt("ANO"),
                        rs.getString("CATEGORIA"),
                        rs.getString("GENERO"),
                        rs.getString("EDITORA")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return livro;
    }

    public void alterarLivro(Livro livro) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "UPDATE tbl_livro SET TITULO = ?, AUTOR = ?, ANO = ?, CATEGORIA = ?, GENERO = ?, EDITORA = ? WHERE ID_LIVRO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, livro.getTitulo());
            comandoSQL.setString(2, livro.getAutor());
            comandoSQL.setInt(3, livro.getAno());
            comandoSQL.setString(4, livro.getCategoria());
            comandoSQL.setString(5, livro.getGenero());
            comandoSQL.setString(6, livro.getEditora());
            comandoSQL.setInt(7, livro.getId());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirLivro(int id) {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "DELETE FROM tbl_livro WHERE ID_LIVRO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Livro> listarTodos() throws SQLException {
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        List<Livro> livros = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tbl_livro";
            comandoSQL = conexao.prepareStatement(sql);
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("ID_LIVRO"));
                livro.setTitulo(rs.getString("TITULO"));
                livro.setAutor(rs.getString("AUTOR"));
                livro.setAno(rs.getInt("ANO"));
                livro.setCategoria(rs.getString("CATEGORIA"));
                livro.setGenero(rs.getString("GENERO"));
                livro.setEditora(rs.getString("EDITORA"));

                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return livros;
    }
}
