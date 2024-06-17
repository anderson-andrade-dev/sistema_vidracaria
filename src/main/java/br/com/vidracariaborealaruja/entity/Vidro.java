package br.com.vidracariaborealaruja.entity;

import br.com.vidracariaborealaruja.record.VidroRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
public class Vidro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome do Vidro não pode ser Nulo!")
    @NotBlank(message = "Nome do Vidro não pode ficar em branco!")
    @Size(min = 4, max = 80, message = "Nome do Vidro tem que ter no mínimo {min} e no máximo {max} !")
    private String nome;
    @NotNull(message = "Espessura não pode ser nula!")
    @PositiveOrZero(message = "Espessura não pode ser negativa!")
    private Long espessura;
    private boolean isTemperado;
    private boolean isLaminado;
    @PositiveOrZero(message = "Preço não pode ser negativo!")
    @NotNull(message = "Preço não pode ser nulo!")
    private BigDecimal preco;

    @Deprecated
    public Vidro() {
    }

    public Vidro(String nome, Long espessura, boolean isTemperado, boolean isLaminado, BigDecimal preco) {
        this.nome = nome;
        this.espessura = espessura;
        this.isTemperado = isTemperado;
        this.isLaminado = isLaminado;
        this.preco = preco;
    }

    public Vidro(VidroRecord vidroRecord) {
        this.nome = vidroRecord.nome();
        this.preco = new BigDecimal(vidroRecord.preco().replace(",", "."));
        this.isTemperado = vidroRecord.isTemperado();
        this.isLaminado = vidroRecord.isLaminado();
        this.espessura = vidroRecord.espessura();
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

    public Long getEspessura() {
        return espessura;
    }

    public void setEspessura(Long espessura) {
        this.espessura = espessura;
    }

    public boolean isTemperado() {
        return isTemperado;
    }

    public void setTemperado(boolean temperado) {
        isTemperado = temperado;
    }

    public boolean isLaminado() {
        return isLaminado;
    }

    public void setLaminado(boolean laminado) {
        isLaminado = laminado;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Vidro atualiza(VidroRecord record) {
        this.nome = record.nome();
        this.espessura = record.espessura();
        this.isLaminado = record.isLaminado();
        this.isTemperado = record.isTemperado();
        this.preco = new BigDecimal(record.preco().replace(",", "."));
        return this;
    }

    public Vidro atualiza(String nome, Long espessura, boolean isTemperado, boolean isLaminado, BigDecimal preco) {
        this.nome = nome;
        this.espessura = espessura;
        this.isLaminado = isLaminado;
        this.isTemperado = isTemperado;
        this.preco = preco;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vidro vidro = (Vidro) o;
        return isTemperado == vidro.isTemperado && isLaminado == vidro.isLaminado && Objects.equals(id, vidro.id) && Objects.equals(nome, vidro.nome) && Objects.equals(espessura, vidro.espessura) && Objects.equals(preco, vidro.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, espessura, isTemperado, isLaminado, preco);
    }

    @Override
    public String toString() {
        return "Vidro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", espessura=" + espessura +
                ", isTemperado=" + isTemperado +
                ", isLaminado=" + isLaminado +
                ", preco=" + preco +
                '}';
    }
}
