package br.com.vidracariaborealaruja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/orcamento", method = RequestMethod.GET)
public class OrcamentoController {
    @GetMapping
    public String formOrcamento() {
        return "/orcamento/formOrcamento";
    }

    @GetMapping("/get_comBandeira")
    public String formOrcComBandeira(Model model) {
        model.addAttribute("pageTitle", "Orçamento Com Bandeira");
        return "/orcamento/formOrcBandeira";
    }

    @GetMapping("/get_semBandeira")
    public String get_formOrcSemBandeira(Model model) {
        model.addAttribute("pageTitle", "Orçamento Sem Bandeira");
        return "/orcamento/formOrcSemBandeira";
    }
}
