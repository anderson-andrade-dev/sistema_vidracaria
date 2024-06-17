package br.com.vidracariaborealaruja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Vao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "vao",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Area> areas;
    @PositiveOrZero(message = "Altura não pode ser negativa!")
    private int altura;
    @PositiveOrZero(message = "Largura não pode ser negativa!")
    private int largura;
    @NotNull(message = "Nome não pode ser nulo!")
    @NotBlank(message = "Nome não pode ficar em branco!")
    @Size(min = 10,max = 80,message = "Nome tem que conter no mínimo {mim} e no máximo de {max} caracteres!")
    private String nome;

    @Deprecated
    public Vao() {
        this.areas = new ArrayList<>();
    }

    public Vao(String nome, int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
        this.nome = nome;
        this.areas=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vao vao = (Vao) o;
        return altura == vao.altura && largura == vao.largura && Objects.equals(id, vao.id) && Objects.equals(areas, vao.areas) && Objects.equals(nome, vao.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, areas, altura, largura, nome);
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", areas=" + areas +
                ", altura=" + altura +
                ", largura=" + largura +
                ", nome='" + nome + '\'' +
                '}';
    }
}
