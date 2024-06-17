package br.com.vidracariaborealaruja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Projeto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome do projeto não pode ser nulo!")
    @NotBlank(message = "Nome do projeto não pode ficar em branco!")
    @Size(min = 10 , max = 100, message = "Nome deve ter no mínimo {min} e no máximo {max} caracteres!")
    private String nome;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="vao_id")
    @NotNull(message = "O Vão não pode ser nulo!")
    private Vao vao;
    private String urlImagem;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="categoria_id")
    private CategoriaProjeto categoriaProjeto;

    @Deprecated
    public Projeto() {
    }

    public Projeto(String nome, Vao vao, String urlImagem) {
        this.nome = nome;
        this.vao = vao;
        this.urlImagem = urlImagem;
    }

    public CategoriaProjeto getCategoriaProjeto() {
        return categoriaProjeto;
    }

    public void setCategoriaProjeto(CategoriaProjeto categoriaProjeto) {
        this.categoriaProjeto = categoriaProjeto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vao getVao() {
        return vao;
    }

    public void setVao(Vao vao) {
        this.vao = vao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(id, projeto.id) && Objects.equals(nome, projeto.nome) && Objects.equals(vao, projeto.vao) && Objects.equals(urlImagem, projeto.urlImagem) && Objects.equals(categoriaProjeto, projeto.categoriaProjeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, vao, urlImagem, categoriaProjeto);
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vao=" + vao +
                ", urlImagem='" + urlImagem + '\'' +
                ", categoriaProjeto=" + categoriaProjeto +
                '}';
    }
}
