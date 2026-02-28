package model;

public abstract class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Novo Usuário: " +
                "\nNome: " + nome +
                "\nE-mail: " + email;
    }
}
