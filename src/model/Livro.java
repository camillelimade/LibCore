package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private Usuario emprestadoPara;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    public void setEmprestadoPara(Usuario emprestadoPara) {
        this.emprestadoPara = emprestadoPara;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


    @Override
    public String toString() {
        return "ID: " + id  +
                "\nTitulo: " + titulo  +
                "\nAutor: " + autor  +
                "\nDisponivel: " + disponivel;
    }
}
