package br.com.vidracariaborealaruja.beans;

import br.com.vidracariaborealaruja.interfaces.Produto;

import java.math.BigDecimal;
import java.util.Objects;

public class Ferragem implements Produto {

    private String nome;
    private String codigo;
    private BigDecimal preco;

    protected Ferragem() {
    }

    public Ferragem(String nome, String codigo, BigDecimal preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public static Ferragem create(String nome, String codigo, BigDecimal preco) {
        return new Ferragem(nome, codigo, preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public BigDecimal getPreco() {
        return this.preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferragem ferragem = (Ferragem) o;
        return Objects.equals(nome, ferragem.nome) &&
                Objects.equals(codigo, ferragem.codigo) &&
                Objects.equals(preco, ferragem.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, preco);
    }

    @Override
    public String toString() {
        return "Ferragem{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precoCusto=" + preco +
                '}';
    }
}
