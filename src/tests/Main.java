package tests;

import repository.LivroRepository;
import models.Livro;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroRepository livroRepository = new LivroRepository();

        while (true) {
            System.out.println("\nSistema de Gestão de Biblioteca");
            System.out.println("1. Adicionar ou Atualizar Livro");
            System.out.println("2. Buscar Livro por ID");
            System.out.println("3. Excluir Livro por ID");
            System.out.println("4. Listar Todos os Livros");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do livro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a categoria do livro: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Digite o gênero do livro: ");
                    String genero = scanner.nextLine();
                    System.out.print("Digite a editora do livro: ");
                    String editora = scanner.nextLine();

                    Livro livro = new Livro(id, titulo, autor, ano, categoria, genero, editora);
                    livroRepository.salvarLivro(livro);
                    System.out.println("Livro salvo com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o ID do livro: ");
                    int livroId = scanner.nextInt();
                    Livro livroBuscado = livroRepository.buscarLivroPorId(livroId);
                    if (livroBuscado != null) {
                        System.out.println("Livro encontrado: " + livroBuscado.getTitulo());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do livro que deseja excluir: ");
                    int excluirId = scanner.nextInt();
                    livroRepository.excluirLivro(excluirId);
                    System.out.println("Livro excluído com sucesso!");
                    break;

                case 4:
                    List<Livro> livros = livroRepository.listarTodosOsLivros();
                    System.out.println("Lista de Todos os Livros:");
                    for (Livro l : livros) {
                        System.out.println(l.getTitulo());
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
