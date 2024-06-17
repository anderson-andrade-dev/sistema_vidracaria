package br.com.vidracariaborealaruja.controller;

import br.com.vidracariaborealaruja.model.ProjetoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/projeto", method = RequestMethod.GET)
public class ProjetoController {
    private final ProjetoModel projetoModel;

    @Autowired
    public ProjetoController(ProjetoModel projetoModel) {
        this.projetoModel = projetoModel;
    }

    @GetMapping
    public String formCadProjeto(Model model) {
        model.addAttribute("pageTitle", "Cadastro de Projeto");
        model.addAttribute("categorias",projetoModel.categorias());
        return "/projeto/formCadProjeto";
    }

    @GetMapping("get_cadCategoria")
    public String formCadCategoria(Model model) {
        model.addAttribute("pageTitle", "Cadastro Categoria");
        return "/projeto/formCadCategoria";
    }

    @PostMapping("cadCategoria")
    public String cadCategoria(String nome) {
        projetoModel.cadastraCategoria(nome);
        return "redirect:/projeto";
    }

    @PostMapping("/cadProjeto")
    public String cadProjeto(String nome,String url,Long divisaoHorizontal,Long divisaoVertical,Long categoriaId){
        projetoModel.cadastraProjeto(nome,url,divisaoHorizontal,divisaoVertical,categoriaId);
        return "redirect:/projeto";
    }

}
