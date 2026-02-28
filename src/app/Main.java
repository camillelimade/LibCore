package app;

import model.Livro;
import model.Usuario;
import service.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca();

        boolean continuar = true;
        int idLivro = 1;

        Usuario userNovo;

        try {
            userNovo = biblioteca.cadastro();
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
            return; // encerra se falhar
        }

        do{
            int opcao = biblioteca.menu();
            switch (opcao) {
                case 1:
                    livros.add(biblioteca.addLivro(idLivro));
                    idLivro++; // id auto incrementado
                    break;
                case 2:
                    biblioteca.listLivros(livros);
                    break;
                case 3:
                    System.out.println("Digite o ID do livro que deseja: ");
                    int idEmp = input.nextInt();
                    input.nextLine();
                    try {
                        biblioteca.realizarEmprestimo(livros, idEmp, userNovo);
                    } catch (Exception e) {
                        System.out.println("Erro no Empréstimo: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Digite a ID do livro que deseja devolver: ");
                    int idDevolucao = input.nextInt();
                    input.nextLine();
                    biblioteca.devolverLivro(livros, idDevolucao);
                    break;
                case 5:
                    System.out.println("Digite o ID do livro que deseja excluir: ");
                    int idEx = input.nextInt();
                    input.nextLine();
                    biblioteca.excluirLivro(livros, idEx);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Encerrando..");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while(continuar);
        input.close();
    }
}
