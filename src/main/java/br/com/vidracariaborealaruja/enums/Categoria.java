package br.com.vidracariaborealaruja.enums;

public enum Categoria {
    ELETRONICOS("Eletronicos");

    private final String nome;
    Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
