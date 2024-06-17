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

/**
 *
 */
@Entity
public class Saida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSaida;
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

    public Saida() {
        dataSaida = LocalDate.now();
    }

    public Saida(BigDecimal valor, String descricao, String responsavel, Caixa caixa) {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
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
        Saida saida = (Saida) o;
        return Objects.equals(id, saida.id) && Objects.equals(dataSaida, saida.dataSaida) && Objects.equals(valor, saida.valor) && Objects.equals(descricao, saida.descricao) && Objects.equals(responsavel, saida.responsavel) && Objects.equals(caixa, saida.caixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataSaida, valor, descricao, responsavel, caixa);
    }

    @Override
    public String toString() {
        return "Saida{" +
                "id=" + id +
                ", dataSaida=" + dataSaida +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", caixa=" + caixa +
                '}';
    }
}
