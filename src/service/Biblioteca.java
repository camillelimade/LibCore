package service;

import exceptions.EmailInvalidoException;
import exceptions.LivroIndisponivelException;
import exceptions.ContatoUserInvalidoException;
import model.Aluno;
import model.Livro;
import model.Professor;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

// classe principal da lógica de negócios pois leva a maioria das funções
public class Biblioteca {
    public void divisor() {
        System.out.println("-----------------------------------------");
    }

    Scanner input = new Scanner(System.in);

    private boolean emailValido(String email) {
        if (email == null) return false;

        return email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public Usuario cadastro() {
        // ux, mensagem de situação do usuario e boas vindas do aplicativo
        divisor();
        System.out.println("Bem vindo(a) ao Cadastro do LibCore! A sua biblioteca virtual");
        divisor();

        // 0. criação da caixa de leitura dos dados para realizar o cadastro
        Scanner cadUser = new Scanner(System.in);

        // 1. recebe nomeUser
        System.out.println("Digite seu nome: ");
        String nomeUser = cadUser.nextLine();

        // 2. via que verifica se nomeUser é válido
        if (nomeUser.isBlank()) {
            throw new ContatoUserInvalidoException("Nome inválido! Tente novamente. ");
        }
        // 1. recebe emailUser
        System.out.println("Digite seu e-mail: ");
        String emailUser = cadUser.nextLine();
        // 2. exceção de email inválido ou vazio
        if (emailUser.isBlank() || !emailValido(emailUser)) {
            throw new EmailInvalidoException("E-mail inválido! Tente novamente.");
        }
        // 1. recebe tipo de usuario (Aluno ou Professor)
        divisor();
        System.out.println("Tipos de usuário: \nAluno: 0 \nProfessor: 1");
        divisor();
        System.out.println("Indique qual o seu usuário: ");
        int tipoUser = cadUser.nextInt();
        cadUser.nextLine(); // limpa buffer

        if (tipoUser == 0) {
            return new Aluno(nomeUser, emailUser);
        } else if (tipoUser == 1) {
            return new Professor(nomeUser, emailUser);
        } else {
            throw new IllegalArgumentException("Tipo inválido!");
        }

    }

    public int menu() {
        divisor();
        System.out.println("Bem vindo(a) ao LibCore, sua biblioteca virtual!");
        System.out.println("1. Adicionar livros");
        System.out.println("2. Listar livros");
        System.out.println("3. Empréstimo de livros");
        System.out.println("4. Devolução de livros");
        System.out.println("5. Excluir livro");
        System.out.println("6. Fechar o programa");


        divisor();
        int opcao;
        while (true) {

            System.out.print("Digite a opção desejada: ");

            if (input.hasNextInt()) {
                opcao = input.nextInt();
                input.nextLine();
                break;
            } else {

                System.out.println("Digite uma entrada válida! ");
                input.nextLine();
            }
        }

        return opcao;
    }

    public Livro addLivro(int id) {
        divisor();
        System.out.println("LibCore — Seu cadastro de Livros");
        divisor();
        System.out.println("Digite o titulo do livro: ");
        String titulo = input.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine();
        Livro novoLivro = new Livro(id, titulo, autor);
        divisor();
        System.out.println("Livro " + titulo + " adicionado com sucesso!");
        return novoLivro;
    }

    public void listLivros(ArrayList<Livro> livros) {
        if (livros.isEmpty()) {
            divisor();
            System.out.println("Nenhum livro encontrado!");

            return;
        }

        divisor();
        System.out.println("LibCore — Sua lista de Livros");
        divisor();
        for (Livro livro : livros) {
            if (livro.isDisponivel() == true) {
                System.out.println(livro.toString());
                divisor();
            }
        }
        System.out.println("Carregando.. ");
    }

    public void realizarEmprestimo(ArrayList<Livro> livros, int id, Usuario usuario) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (livro.isDisponivel() == true) {
                    divisor();
                    System.out.println("O livro " + livro.getTitulo() + " de " + livro.getAutor() + " foi emprestado com sucesso! ");
                    livro.setDisponivel(false);
                } else {
                    divisor();
                    throw new LivroIndisponivelException(
                            "O livro " + livro.getTitulo() + " já foi emprestado! "
                    );
                }
                return;
            }
        }
        divisor();
        System.out.println("Livro com ID " + id + " não encontrado!");
    }

    public void devolverLivro(ArrayList<Livro> livros, int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                if (!livro.isDisponivel()) {
                    livro.setDisponivel(true);
                    divisor();
                    System.out.println("Livro " + livro.getTitulo() + " de " + livro.getAutor() + " foi devolvido com sucesso!");
                    divisor();
                } else {
                    divisor();
                    System.out.println("O livro não está emprestado!");
                    divisor();
                }
                return;
            }
        }
        System.out.println("Livro com ID " + id + " não encontrado!");
    }

    /*
    *  if (contatos.get(i).getNome().equalsIgnoreCase(nomeExcluir)) {
                    contatos.remove(i);
                    return;
                }
    * */
    public void excluirLivro(ArrayList<Livro> livros, int id) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                System.out.println("Livro " + livros.get(i).getTitulo() + " de " + livros.get(i).getAutor() + " foi excluído com sucesso!");
                livros.remove(i);
                return;
            }
        }
        System.out.println("Livro com ID " + id + " não encontrado! ");
    }
}
