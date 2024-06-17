/**
 * Autor: Anderson Andrade:.
 * Data Criação: 26 de mar. de 2024
 */
package br.com.vidracariaborealaruja.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.vidracariaborealaruja.model.ContaModel;

/**
 *
 */
@Controller
@RequestMapping(value = "/contas", method = RequestMethod.GET)
public class ContaController {

    private final ContaModel conta;

    @Autowired
    public ContaController(ContaModel conta) {
        this.conta = conta;
    }

    @PostMapping("/pagar")
    public ModelAndView pagar(Long id, String juros, String desconto) {
        LocalDateTime hoje = LocalDateTime.now();
        juros = juros.replace(",", ".");
        desconto = desconto.replace(",", ".");
        conta.pagar(id, hoje, new BigDecimal(juros), new BigDecimal(desconto));
        return new ModelAndView("redirect:/caixa/principal");

    }

    @PostMapping("/antecipar")
    public ModelAndView antecipar(Long id, String desconto) {
        conta.antecipar(id, new BigDecimal(desconto.replace("'", ".")));
        return new ModelAndView("redirect:/caixa/principal");
    }

    @PostMapping("/adiar")
    public ModelAndView adiar(Long id, String data) {
        conta.adiar(id, LocalDate.parse(data, DateTimeFormatter.ofPattern("yyy-MM-dd")));
        return new ModelAndView("redirect:/caixa/principal");
    }

    @PostMapping("/adicionar")
    public ModelAndView inserir(String valor, String data, String descricao) {
        LocalDate dataVencimento = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        conta.adicionar(new BigDecimal(valor.replace(",", ".")), dataVencimento, descricao);
        return new ModelAndView("redirect:/caixa/principal");
    }

    @GetMapping("/g_antecipar")
    public String formAntecipar(Long id, String valor, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("valor", valor);
        return "formAnteciparConta";

    }

    @GetMapping("/g_pagar")
    public String formPagar(Long id, String valor, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("valor", valor);
        return "formPagarConta";
    }

    @GetMapping("/g_adiar")
    public String formAdiar(Long id, Model model) {
        model.addAttribute("id", id);
        return "formAdiarConta";
    }

    @GetMapping("/g_adicionar")
    public String formAdicionar() {
        return "formAdicionarConta";
    }
}
