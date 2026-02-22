package service;

import model.Livro;

import java.util.ArrayList;
import java.util.Scanner;

// classe principal da lógica de negócios pois leva a maioria das funções
public class Biblioteca {
    public void divisor(){
        System.out.println("-----------------------------------------");
    }
    Scanner input = new Scanner(System.in);
    public int menu(){
        divisor();
        System.out.println("Bem vindo(a) ao LibCore, sua biblioteca virtual!");
        System.out.println("1. Adicionar livros");
        System.out.println("2. Listar livros");
        System.out.println("3. Empréstimo de livros");
        System.out.println("4. Devolução de livros");
        System.out.println("5. Excluir livro");
        System.out.println("6. Fechar o programa");
        divisor();
        System.out.println("Digite a opção desejada: ");
        divisor();
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

    public Livro addLivro(int id){
        System.out.println("LibCore - Cadastro de Livros");
        System.out.println("Digite o titulo do livro: ");
        String titulo = input.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine();
        Livro novoLivro = new Livro(id, titulo, autor);
        divisor();
        System.out.println("Livro " + titulo + " adicionado com sucesso!");
        return novoLivro;
    }
    public void listLivros(ArrayList<Livro> livros){
        if (livros.isEmpty()){
            divisor();
            System.out.println("Nenhum livro encontrado!");
            System.out.println();
            return;
        }

        divisor();
        System.out.println("LibCore - Lista de Livros");
        divisor();
        for (Livro livro : livros){
            System.out.println(livro.toString());
        }

        System.out.println();

    }
}
