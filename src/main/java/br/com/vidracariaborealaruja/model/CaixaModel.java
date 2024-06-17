/**
 * Autor: Anderson Andrade:.
 * Data Criação: 23 de fev. de 2024
 */
package br.com.vidracariaborealaruja.model;

import br.com.vidracariaborealaruja.entity.Caixa;
import br.com.vidracariaborealaruja.entity.Entrada;
import br.com.vidracariaborealaruja.entity.Saida;
import br.com.vidracariaborealaruja.repository.CaixaRepository;
import br.com.vidracariaborealaruja.repository.EntradaRepository;
import br.com.vidracariaborealaruja.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
@Component
public class CaixaModel {
    private final CaixaRepository caixaRepository;
    private final EntradaRepository entradaRepository;
    private final SaidaRepository saidaRepository;

    @Autowired
    public CaixaModel(CaixaRepository caixaRepository, EntradaRepository entradaRepository, SaidaRepository saidaRepository) {
        this.caixaRepository = caixaRepository;
        this.entradaRepository = entradaRepository;
        this.saidaRepository = saidaRepository;
    }

    public Caixa buscaCaixa(LocalDate data) {
        return caixaRepository.findByData(data);
    }

    public void abrirCaixa() {
        boolean caixaEncontrado = false;

        List<Caixa> caixas = (List<Caixa>) caixaRepository.findAll();

        if (caixas.isEmpty()) {
            criarPrimeiroCaixa();
        } else {

            for (Caixa cx : caixas) {
                if (cx.getDataAbertura().isBefore(LocalDate.now()) && !cx.isFechado()) {
                    cx.setDataFechamento(cx.getDataAbertura());
                    atualizaCaixa(cx);
                    cx.setFechado(true);
                    caixaRepository.save(cx);
                }
            }

            for (Caixa cx : caixas) {
                if (cx.getDataAbertura().isEqual(LocalDate.now()) && !cx.isFechado()) {
                    caixaEncontrado = true;
                    break;
                }
            }
        }
        if (!caixaEncontrado) {
           caixas.stream()
                   .filter(Caixa::isFechado)
                   .filter(c -> c.getDataFechamento().getMonth() == LocalDate.now().getMonth())
                   .max(Comparator.comparing(Caixa::getDataFechamento))
                   .ifPresent(this::criarCaixa);
        }

    }

    public void entrada(BigDecimal valor, String descricao, String responsavel) {
        LocalDate hoje = LocalDate.now();
        Caixa caixa = caixaDoDia(hoje);
        if (caixa.getEntradas() != null) {
            Entrada entrada = new Entrada(valor, descricao, responsavel,caixa);
            entradaRepository.save(entrada);
            caixa.getEntradas().add(entrada);
            caixaRepository.save(caixa);

        }
    }

    public void saida(BigDecimal valor, String descricao, String responsavel) {
        LocalDate hoje = LocalDate.now();
        Caixa caixa =caixaDoDia(hoje);
        try {
            Saida saida = new Saida(valor, descricao, responsavel,caixa);
            saidaRepository.save(saida);
            caixa.getSaidas().add(saida);
            caixaRepository.save(caixa);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Entrada> entradas(LocalDate data) {
        return caixaDoDia(data).getEntradas();
    }

    public List<Saida> saidas(LocalDate data) {
        return caixaDoDia(data).getSaidas();
    }

    public BigDecimal somaEntradas(LocalDate data) {
        BigDecimal soma = BigDecimal.ZERO;
        try {
            for (Entrada entrada : caixaDoDia(data).getEntradas()) {
                soma = soma.add(entrada.getValor());
            }
            return soma;
        } catch (NullPointerException e) {
            return soma;
        }
    }

    public BigDecimal somaSaidas(LocalDate data) {
        BigDecimal soma = BigDecimal.ZERO;

        try {
            Caixa cx = caixaDoDia(data);
            for (Saida saida : cx.getSaidas()) {
                soma = soma.add(saida.getValor());
            }
            return soma;
        } catch (NullPointerException e) {
            return soma;
        }

    }

    public BigDecimal valorTempoReal() {
        LocalDate hoje = LocalDate.now();
        return caixaDoDia(hoje).getValorFechamento();
    }

    private Caixa caixaDoDia(LocalDate data) {
        Caixa caixa = caixaRepository.findByData(data);
        if (caixa == null) {
            abrirCaixa();
            caixa = caixaRepository.findByData(data);
        }
        atualizaCaixa(caixa);
        return caixa;
    }

    private void atualizaCaixa(Caixa caixaDoDia) {
        BigDecimal somaSaidas = BigDecimal.ZERO;
        BigDecimal somaEntradas = BigDecimal.ZERO;
        BigDecimal valorEmTempoReal = BigDecimal.ZERO;

        try {
            for (Saida saida : caixaDoDia.getSaidas()) {
                somaSaidas = somaSaidas.add(saida.getValor());

            }
            for (Entrada entrada : caixaDoDia.getEntradas()) {
                somaEntradas = somaEntradas.add(entrada.getValor());
            }

            valorEmTempoReal = valorEmTempoReal.add(caixaDoDia.getValorAbertura());
            valorEmTempoReal = valorEmTempoReal.add(somaEntradas);
            valorEmTempoReal = valorEmTempoReal.subtract(somaSaidas);
            caixaDoDia.setValorFechamento(valorEmTempoReal);
        } catch (NullPointerException e) {
            throw new RuntimeException("Erro ao Atualizar o Caixa :" + e);
        }

    }

    private void criarCaixa(Caixa caixaAnterior) {
        Caixa novoCaixa = new Caixa();
        novoCaixa.setDataAbertura(LocalDate.now());
        novoCaixa.setValorAbertura(caixaAnterior.getValorFechamento());
        caixaRepository.save(novoCaixa);
    }

    private void criarPrimeiroCaixa() {
        Caixa caixa = new Caixa();
        caixa.setDataAbertura(LocalDate.now());
        caixa.setValorAbertura(BigDecimal.ZERO);
        caixaRepository.save(caixa);
    }

}