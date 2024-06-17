package br.com.vidracariaborealaruja.entity;

import br.com.vidracariaborealaruja.record.PerfilRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome não pode ser Nulo!")
    @NotBlank(message = "Nome não pode ficar em brando!")
    @Size(min = 2, max = 80, message = "Nome do perfil tem que ter no mínimo de {mim} e no máximo de {max} letras")
    private String nome;
    @PositiveOrZero(message = "Peso não pode ser negativo!")
    private Double peso;


    @Deprecated
    public Perfil() {
    }

    public Perfil(String nome, Double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public Perfil(PerfilRecord perfilRecord) {
        this.nome = perfilRecord.nome();
        this.peso = perfilRecord.peso();
    }

    public Perfil atualiza(String nome, Double peso) {
        this.nome = nome;
        this.peso = peso;
        return this;
    }

    public Perfil atualiza(PerfilRecord perfilRecord) {
        this.nome = perfilRecord.nome();
        this.peso = perfilRecord.peso();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id) && Objects.equals(nome, perfil.nome) && Objects.equals(peso, perfil.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, peso);
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                '}';
    }
}
