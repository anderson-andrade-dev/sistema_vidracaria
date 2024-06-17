/**
 * Autor: Anderson Andrade:.
 * Data Criação: 26 de mar. de 2024
 */
package br.com.vidracariaborealaruja.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 *
 */
@Entity
public class Conta implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @PositiveOrZero
    private BigDecimal valor = BigDecimal.ZERO;
    @PositiveOrZero
    private BigDecimal juros = BigDecimal.ZERO;
    @PositiveOrZero
    private BigDecimal desconto = BigDecimal.ZERO;
    private LocalDate dataAgendada;
    private LocalDateTime dataPagamento;
    private LocalDate dataNovoAgendamento;
    private LocalDateTime dataLancamentoSistema;
    private boolean paga = false;
    @NotNull
    @NotBlank
    private String descricao;

    /**
     *
     */
    public Conta() {
    }

    public Conta(@NotNull @PositiveOrZero BigDecimal valor, LocalDate dataAgendada, LocalDateTime dataLancamentoSistema,
                 @NotNull @NotBlank String descricao) {
        this.valor = valor;
        this.dataAgendada = dataAgendada;
        this.dataLancamentoSistema = dataLancamentoSistema;
        this.descricao = descricao;
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

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataNovoAgendamento() {
        return dataNovoAgendamento;
    }

    public void setDataNovoAgendamento(LocalDate dataNovoAgendamento) {
        this.dataNovoAgendamento = dataNovoAgendamento;
    }

    public LocalDateTime getDataLancamentoSistema() {
        return dataLancamentoSistema;
    }

    public void setDataLancamentoSistema(LocalDateTime dataLancamentoSistema) {
        this.dataLancamentoSistema = dataLancamentoSistema;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataAgendada, dataLancamentoSistema, dataNovoAgendamento, dataPagamento, desconto,
                descricao, id, juros, paga, valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        return Objects.equals(dataAgendada, other.dataAgendada)
                && Objects.equals(dataLancamentoSistema, other.dataLancamentoSistema)
                && Objects.equals(dataNovoAgendamento, other.dataNovoAgendamento)
                && Objects.equals(dataPagamento, other.dataPagamento) && Objects.equals(desconto, other.desconto)
                && Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
                && Objects.equals(juros, other.juros) && paga == other.paga && Objects.equals(valor, other.valor);
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", valor=" + valor + ", juros=" + juros + ", desconto=" + desconto
                + ", dataAgendada=" + dataAgendada + ", dataPagamento=" + dataPagamento + ", dataNovoAgendamento="
                + dataNovoAgendamento + ", dataLancamentoSistema=" + dataLancamentoSistema + ", paga=" + paga
                + ", descricao=" + descricao + "]";
    }

}
