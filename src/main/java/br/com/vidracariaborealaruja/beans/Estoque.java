package br.com.vidracariaborealaruja.beans;

import java.util.Objects;

public class Estoque {
    private final String nome;
    private final int estante;
    private final int prateleira;
    private final int gaveta;

    public Estoque(String nome, int estante, int prateleira, int gaveta) {
        this.nome = nome;
        this.estante = estante;
        this.prateleira = prateleira;
        this.gaveta = gaveta;
    }

    public String getNome() {
        return nome;
    }

    public int getEstante() {
        return estante;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public int getGaveta() {
        return gaveta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return estante == estoque.estante && prateleira == estoque.prateleira && gaveta == estoque.gaveta && Objects.equals(nome, estoque.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, estante, prateleira, gaveta);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "nome='" + nome + '\'' +
                ", estante=" + estante +
                ", prateleira=" + prateleira +
                ", gaveta=" + gaveta +
                '}';
    }
}
