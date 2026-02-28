package model;

public class Professor extends Usuario{
    public Professor(String nome, String email) {
        super(nome, email);
    }
    public String getTipo(){
        return "Professor: " + getNome();
    }
}
