package App;

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
        do{
            int opcao = biblioteca.menu();
            switch (opcao) {
                case 1:
                    break;
                case 6:
                    continuar = true;
                    System.out.println("Encerrando..");
                    break;
            }
        }while(!continuar);
    }
}
