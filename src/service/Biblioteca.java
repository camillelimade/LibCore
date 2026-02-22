package service;

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
}
