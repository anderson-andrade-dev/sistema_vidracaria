/**
 * Autor: Anderson Andrade:.
 * Data Criação: 26 de mar. de 2024
 */
package br.com.vidracariaborealaruja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vidracariaborealaruja.entity.Conta;
import br.com.vidracariaborealaruja.repository.ContaRepository;

/**
 *
 */
@Component
public class ContaModel {
    @Autowired
    private ContaRepository repository;
    @Autowired
    private CaixaModel caixaModel;

    public ContaModel() {
    }

    public void pagar(Long id, LocalDateTime data, BigDecimal juros, BigDecimal desconto) {
        Optional<Conta> conta = repository.findById(id);
        conta.ifPresent((c) -> {
            c.setDataPagamento(data);
            c.setJuros(juros);
            c.setDesconto(desconto);
            c.setPaga(true);
            repository.save(c);
            caixaModel.saida(valoresPagos(c), c.getDescricao(), "Sistema: Administrador");
        });

    }

    public void antecipar(Long id, BigDecimal desconto) {
        Optional<Conta> conta = repository.findById(id);
        conta.ifPresent((c) -> {
            c.setDesconto(desconto);
            c.setDataPagamento(LocalDateTime.now());
            c.setPaga(true);
            repository.save(c);
            caixaModel.saida(valoresPagos(c), c.getDescricao(), "Sistema: Administrador");
        });

    }

    public void adiar(Long id, LocalDate novaData) {
        Optional<Conta> conta = repository.findById(id);
        conta.ifPresent((c) -> {
            c.setDataNovoAgendamento(novaData);
            repository.save(c);
        });
    }

    /**
     * @param valor
     * @param dataAgendada
     */
    public void adicionar(BigDecimal valor, LocalDate dataAgendada, String descricao) {
        repository.save(new Conta(valor, dataAgendada, LocalDateTime.now(), descricao));
    }

    /**
     * @return
     */
    public List<Conta> agendadas() {
        List<Conta> contas = new ArrayList<>();

        for (Conta conta : repository.findAll()) {
            if (!conta.isPaga()) {
                contas.add(conta);
            }
        }

        return contas;
    }

    /**
     * @param now
     * @return
     */
    public List<Conta> pagasDia(LocalDate data) {
        List<Conta> contas = new ArrayList<Conta>();

        repository.findAll().forEach(c -> {
            if (c.isPaga() && data.isEqual(c.getDataPagamento().toLocalDate())) {
                contas.add(c);
            }
        });
        return contas;
    }

    public BigDecimal somaContasPagas(LocalDate data) {
        List<Conta> pagasDia = pagasDia(data);
        BigDecimal totalSoma = BigDecimal.ZERO;
        for (Conta conta : pagasDia) {
            totalSoma = totalSoma.add(conta.getValor());
            totalSoma = totalSoma.add(conta.getJuros());
            totalSoma = totalSoma.subtract(conta.getDesconto());

        }
        return totalSoma;
    }

    public BigDecimal valoresPagos(Conta conta) {
        BigDecimal totalSoma = BigDecimal.ZERO;
        totalSoma = totalSoma.add(conta.getValor());
        totalSoma = totalSoma.add(conta.getJuros());
        totalSoma = totalSoma.subtract(conta.getDesconto());

        return totalSoma;
    }

}
