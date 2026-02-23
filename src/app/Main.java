package app;

import model.Livro;
import service.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<Livro>();
        Biblioteca  biblioteca = new Biblioteca();
        boolean continuar = false;
        int idLivro = 1;
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
                    biblioteca.realizarEmprestimo(livros, idEmp);
                    break;
                case 4:
                    System.out.println("Digite a ID do livro que deseja devolver: ");
                    int idDevolucao = input.nextInt();
                    input.nextLine();
                    biblioteca.devolverLivro(livros, idDevolucao);
                    break;
                case 6:
                    continuar = true;
                    System.out.println("Encerrando..");
                    break;
            }
        }while(!continuar);
    }
}
