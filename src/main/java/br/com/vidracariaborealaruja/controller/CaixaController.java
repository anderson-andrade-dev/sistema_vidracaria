/**
 * Autor: Anderson Andrade:.
 * Data Criação: 23 de fev. de 2024
 */
package br.com.vidracariaborealaruja.controller;

import br.com.vidracariaborealaruja.model.CaixaModel;
import br.com.vidracariaborealaruja.model.ContaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 */
@Controller
@RequestMapping(value = "/caixa", method = RequestMethod.GET)
public class CaixaController {

    private final CaixaModel caixa;
    private final ContaModel conta;

    @Autowired
    public CaixaController(CaixaModel caixa, ContaModel conta) {
        this.caixa = caixa;
        this.conta = conta;
    }

    @GetMapping("/principal")
    public String caixa(Model model) {
        caixa.abrirCaixa();
        LocalDate hoje = LocalDate.now();
        model.addAttribute("entradas", caixa.somaEntradas(hoje));
        model.addAttribute("saidas", caixa.somaSaidas(hoje));
        model.addAttribute("tempoReal", caixa.valorTempoReal());
        model.addAttribute("listaEntradas", caixa.entradas(hoje));
        model.addAttribute("listaSaidas", caixa.saidas(hoje));
        model.addAttribute("listaContas", conta.agendadas());
        model.addAttribute("listaContasPagasDia", conta.somaContasPagas(hoje));
        model.addAttribute("pageTitle", "Caixa");
        return "formCaixa";

    }

    @GetMapping("/ent")
    public String ent() {
        return "formEntrada";

    }

    @PostMapping("/entrada")
    public ModelAndView entrada(String valor, String descricao, String responsavel) {

        caixa.abrirCaixa();
        caixa.entrada(new BigDecimal(valor.replace(",", ".")), descricao, responsavel);

        return new ModelAndView("redirect:principal");
    }

    @GetMapping("/sai")
    public String sai() {
        return "formSaida";
    }

    @PostMapping("/saida")
    public ModelAndView saida(String valor, String descricao, String responsavel) {
        caixa.abrirCaixa();
        caixa.saida(new BigDecimal(valor.replace(",", ".")), descricao, responsavel);
        return new ModelAndView("redirect:principal");

    }


}
