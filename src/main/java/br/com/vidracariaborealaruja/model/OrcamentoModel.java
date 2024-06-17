package br.com.vidracariaborealaruja.model;

import br.com.vidracariaborealaruja.beans.Produto;
import br.com.vidracariaborealaruja.entity.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrcamentoModel {
    private Cliente cliente;
    private List<Produto> produtos;

    public OrcamentoModel(Cliente cliente, List<Produto> produtos) {
        if(cliente == null){
            throw new IllegalArgumentException("Cliente não pode ser nulo!");
        }
        if(produtos == null){
            throw  new IllegalArgumentException("Lista de Produto não pode ser nula!");
        }
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public BigDecimal total() {
        return produtos.stream().map(Produto::getPrecoVenda).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalCusto() {
        return produtos.stream().map(Produto::getPrecoCusto).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrcamentoModel that = (OrcamentoModel) o;
        return Objects.equals(cliente, that.cliente) && Objects.equals(produtos, that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, produtos);
    }

}
