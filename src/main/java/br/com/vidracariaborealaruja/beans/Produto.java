package br.com.vidracariaborealaruja.beans;

import br.com.vidracariaborealaruja.enums.Categoria;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private final String nome;
    private final BigDecimal precoCusto;
    private final BigDecimal precoVenda;
    private final Estoque estoque;

    public Produto(String nome, BigDecimal precoCusto, BigDecimal precoVenda, Estoque estoque) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public  BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public  BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public  Estoque getEstoque() {
        return estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(precoCusto, produto.precoCusto) && Objects.equals(precoVenda, produto.precoVenda) && Objects.equals(estoque, produto.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, precoCusto, precoVenda, estoque);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", precoCusto=" + precoCusto +
                ", precoVenda=" + precoVenda +
                ", estoque=" + estoque +
                '}';
    }
}
