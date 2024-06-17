/**
 * Autor: Anderson Andrade:.
 * Data Criação: 23 de fev. de 2024
 */
package br.com.vidracariaborealaruja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private boolean fechado = true;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "caixa_id")
    private List<Entrada> entradas;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "caixa_id")
    private List<Saida> saidas;
    @PositiveOrZero
    private BigDecimal valorAbertura;
    @PositiveOrZero
    private BigDecimal valorFechamento;

    public Caixa() {
        this.fechado = false;
        this.dataAbertura = LocalDate.now();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public List<Entrada> getEntradas() {

        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Saida> getSaidas() {
        return saidas;
    }

    public void setSaidas(List<Saida> saidas) {
        this.saidas = saidas;
    }

    public BigDecimal getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(BigDecimal valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public BigDecimal getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(BigDecimal valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    @Override
    public String toString() {
        return "Caixa [id=" + id + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento
                + ", fechado=" + fechado + ", entradas=" + entradas + ", saidas=" + saidas + ", valorAbertura="
                + valorAbertura + ", valorFechamento=" + valorFechamento + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataAbertura, dataFechamento, entradas, fechado, id, saidas, valorAbertura,
                valorFechamento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Caixa other = (Caixa) obj;
        return Objects.equals(dataAbertura, other.dataAbertura) && Objects.equals(dataFechamento, other.dataFechamento)
                && Objects.equals(entradas, other.entradas) && fechado == other.fechado && Objects.equals(id, other.id)
                && Objects.equals(saidas, other.saidas) && Objects.equals(valorAbertura, other.valorAbertura)
                && Objects.equals(valorFechamento, other.valorFechamento);
    }

}
