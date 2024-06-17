/**
 * Autor: Anderson Andrade:.
 * Data Criação: 23 de fev. de 2024
 */
package br.com.vidracariaborealaruja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEntrada;
    @Positive
    private BigDecimal valor;
    @NotBlank
    @Size(max = 255)
    private String descricao;
    @NotBlank
    @Size(max = 60)
    private String responsavel;
    @ManyToOne
    private Caixa caixa;
    public Entrada() {
        dataEntrada = LocalDate.now();
    }

    public Entrada(BigDecimal valor, String descricao, String responsavel , Caixa caixa) {
        this();
        this.valor = valor;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.caixa = caixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(id, entrada.id) && Objects.equals(dataEntrada, entrada.dataEntrada) && Objects.equals(valor, entrada.valor) && Objects.equals(descricao, entrada.descricao) && Objects.equals(responsavel, entrada.responsavel) && Objects.equals(caixa, entrada.caixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataEntrada, valor, descricao, responsavel, caixa);
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", caixa=" + caixa +
                '}';
    }
}
