package br.com.vidracariaborealaruja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Area implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @PositiveOrZero(message = "Altura não pode ser negativa!")
    private int altura;
    @PositiveOrZero(message = "Largura não pode ser negativa!")
    private int largura;
    @PositiveOrZero(message = "Posição vertical não pode ser negativa!")
    private int posicaoVertical;
    @PositiveOrZero(message = "Posição Horizontal não pode ser negativa!")
    private int posicaoHorizontal;
    @PositiveOrZero(message = "Folga da Altura não pode ser negativa!")
    private int folgaAltura;
    @PositiveOrZero(message = "Folga da Largura não pode ser negativa!")
    private int folgaLargura;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Vao vao;

    public Area() {
    }

    public Area(int altura, int largura, int posicaoVertical, int posicaoHorizontal, int folgaAltura, int folgaLargura, Vao vao) {
        this.altura = altura;
        this.largura = largura;
        this.posicaoVertical = posicaoVertical;
        this.posicaoHorizontal = posicaoHorizontal;
        this.folgaAltura = folgaAltura;
        this.folgaLargura = folgaLargura;
        this.vao = vao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getPosicaoVertical() {
        return posicaoVertical;
    }

    public void setPosicaoVertical(int posicaoVertical) {
        this.posicaoVertical = posicaoVertical;
    }

    public int getPosicaoHorizontal() {
        return posicaoHorizontal;
    }

    public void setPosicaoHorizontal(int posicaoHorizontal) {
        this.posicaoHorizontal = posicaoHorizontal;
    }

    public int getFolgaAltura() {
        return folgaAltura;
    }

    public void setFolgaAltura(int folgaAltura) {
        this.folgaAltura = folgaAltura;
    }

    public int getFolgaLargura() {
        return folgaLargura;
    }

    public void setFolgaLargura(int folgaLargura) {
        this.folgaLargura = folgaLargura;
    }

    public Vao getVao() {
        return vao;
    }

    public void setVao(Vao vao) {
        this.vao = vao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return altura == area.altura && largura == area.largura && posicaoVertical == area.posicaoVertical && posicaoHorizontal == area.posicaoHorizontal && folgaAltura == area.folgaAltura && folgaLargura == area.folgaLargura && Objects.equals(id, area.id) && Objects.equals(vao, area.vao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, altura, largura, posicaoVertical, posicaoHorizontal, folgaAltura, folgaLargura, vao);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", altura=" + altura +
                ", largura=" + largura +
                ", posicaoVertical=" + posicaoVertical +
                ", posicaoHorizontal=" + posicaoHorizontal +
                ", folgaAltura=" + folgaAltura +
                ", folgaLargura=" + folgaLargura +
                ", vao=" + vao +
                '}';
    }
}
