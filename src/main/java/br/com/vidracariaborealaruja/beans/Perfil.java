package br.com.vidracariaborealaruja.beans;

import br.com.vidracariaborealaruja.interfaces.Produto;

import java.math.BigDecimal;

public class Perfil implements Produto {

    private final int medida;
    private final String nome;
    private final String codigo;
    private final double peso;
    private final BigDecimal preco;

    private Perfil(int medida, String nome, String codigo, double peso, BigDecimal preco) {
        this.medida = medida;
        this.nome = nome;
        this.codigo = codigo;
        this.peso = peso;
        this.preco = preco.multiply(BigDecimal.valueOf(peso));
    }

    public static Perfil create(int medida, String nome, String codigo, double peso, BigDecimal preco) {
        return new Perfil(medida, nome, codigo, peso, preco);
    }

    @Override
    public BigDecimal getPreco() {
        return preco;
    }
}
