package br.com.vidracariaborealaruja.beans;

import br.com.vidracariaborealaruja.interfaces.Produto;
import br.com.vidracariaborealaruja.uteis.Medida;

import java.math.BigDecimal;
import java.util.Objects;

public class Vidro implements Produto {

    private final int altura;
    private final int largura;
    private final String nome;
    private final BigDecimal preco;
    private final int espessura;


    private Vidro(int altura, int largura, BigDecimal preco, String nome, int espessura) {
        this.altura = altura;
        this.largura = largura;
        this.preco = calculaPreco(altura, largura, preco);
        this.nome = nome;
        this.espessura = espessura;

    }

    public static Vidro create(int altura, int largura, BigDecimal preco, String nome, int espessura) {
        return new Vidro(altura, largura, preco, nome, espessura);
    }

    @Override
    public BigDecimal getPreco() {
        return this.preco;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public String getNome() {
        return nome;
    }

    public int getEspessura() {
        return espessura;
    }

    private BigDecimal calculaPreco(int altura, int largura, BigDecimal preco) {
        Medida medida = Medida.create();
        int alt = medida.aredondamento(altura, 100);
        int lar = medida.aredondamento(largura, 100);
        int metroQuadrado = medida.metroQuadrado(lar, alt);
        preco = preco.multiply(BigDecimal.valueOf(metroQuadrado));
        preco = preco.divide(BigDecimal.valueOf(100));
        return preco.setScale(2);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vidro vidro = (Vidro) o;
        return altura == vidro.altura && largura == vidro.largura && espessura == vidro.espessura && Objects.equals(nome, vidro.nome) && Objects.equals(preco, vidro.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(altura, largura, nome, preco, espessura);
    }

    @Override
    public String toString() {
        return "Vidro{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", nome='" + nome + '\'' +
                ", precoCusto=" + preco +
                ", espessura=" + espessura +
                '}';
    }
}
