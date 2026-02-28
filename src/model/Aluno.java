package model;

public class Aluno extends Usuario {
    public Aluno(String nome, String email) {
        super(nome, email);
    }
    public String getTipo(){
        return getNome() + " (Aluno)";
    }

}
