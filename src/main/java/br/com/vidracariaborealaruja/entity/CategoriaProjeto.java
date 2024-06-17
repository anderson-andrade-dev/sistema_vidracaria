package br.com.vidracariaborealaruja.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CategoriaProjeto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome da categoria não pode ser nulo!")
    @NotBlank(message = "Nome da categoria não pode ficar em branco!")
    @Size(min = 5, max = 150, message = "Nome da Categoria mínimo de {min} e máximo de {max} caracteres")
    @Column(length = 80, unique = true)
    private String nome;
    @OneToMany(mappedBy = "categoriaProjeto",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Projeto> projetos;
    @Deprecated
    public CategoriaProjeto() {
        this.projetos = new ArrayList<>();
    }

    public CategoriaProjeto(String nome) {
        this.projetos = new ArrayList<>();
        this.nome = nome;
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

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaProjeto that = (CategoriaProjeto) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(projetos, that.projetos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, projetos);
    }

    @Override
    public String toString() {
        return "CategoriaProjeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", projetos=" + projetos +
                '}';
    }
}
