package br.com.vidracariaborealaruja.beans;

import br.com.vidracariaborealaruja.interfaces.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Janela implements Produto {
    private int divisaoPeca;
    private int altura;
    private int largura;
    private Vidro vidro;
    private List<Perfil> perfis;
    private List<Ferragem> ferragens;
    private List<Vidro> vidros;

    protected Janela() {

    }

    public Janela(int divisaoPeca, int altura, int largura, List<Perfil> perfis,
                  List<Ferragem> ferragens, List<Vidro> vidros) {
        this();
        this.divisaoPeca = divisaoPeca;
        this.altura = altura;
        this.largura = largura;
        this.vidros = vidros;
        this.perfis = perfis;
        this.ferragens = ferragens;
    }

    @Override
    public BigDecimal getPreco() {
        BigDecimal precoPerfils = BigDecimal.ZERO;
        BigDecimal precoFerragens = BigDecimal.ZERO;
        BigDecimal precoVidro = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        for (Ferragem ferragem : ferragens) {
            precoFerragens = precoFerragens.add(ferragem.getPreco());
        }
        for (Perfil perfis : perfis) {
            precoPerfils = precoPerfils.add(perfis.getPreco());
        }
        for (Vidro vidro : vidros) {
            precoVidro = precoVidro.add(vidro.getPreco());
        }

        return total.add(precoFerragens).add(precoVidro).add(precoPerfils);
    }

    public int getDivisaoPeca() {
        return divisaoPeca;
    }

    public void setDivisaoPeca(int divisaoPeca) {
        this.divisaoPeca = divisaoPeca;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public Vidro getVidro() {
        return vidro;
    }

    public void setVidro(Vidro vidro) {
        this.vidro = vidro;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public List<Ferragem> getFerragens() {
        return ferragens;
    }

    public void setFerragens(List<Ferragem> ferragens) {
        this.ferragens = ferragens;
    }

    public List<Vidro> getVidros() {
        return vidros;
    }

    public void setVidros(List<Vidro> vidros) {
        this.vidros = vidros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Janela janela = (Janela) o;
        return divisaoPeca == janela.divisaoPeca &&
                altura == janela.altura &&
                largura == janela.largura &&
                Objects.equals(vidro, janela.vidro) &&
                Objects.equals(perfis, janela.perfis) &&
                Objects.equals(ferragens, janela.ferragens) &&
                Objects.equals(vidros, janela.vidros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisaoPeca, altura, largura, vidro, perfis, ferragens, vidros);
    }

    @Override
    public String toString() {
        return "Janela{" +
                "divisaoPeca=" + divisaoPeca +
                ", altura=" + altura +
                ", largura=" + largura +
                ", vidro=" + vidro +
                ", perfis=" + perfis +
                ", ferragens=" + ferragens +
                ", vidros=" + vidros +
                '}';
    }
}

