package br.com.vidracariaborealaruja.controller;

import br.com.vidracariaborealaruja.entity.Ferragem;
import br.com.vidracariaborealaruja.model.ProdutoModel;
import br.com.vidracariaborealaruja.record.FerragemRecord;
import br.com.vidracariaborealaruja.record.PerfilRecord;
import br.com.vidracariaborealaruja.record.VidroRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/produto", method = RequestMethod.GET)
public class ProdutoController {

    private final ProdutoModel produtoModel;

    @Autowired
    public ProdutoController(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    @PostMapping("/adicionar")
    public String cadastroFerragem(@RequestParam("codigo") String codigo,
                                   @RequestParam("descricao") String descricao,
                                   @RequestParam("preco") String preco, Model model) {
        preco = preco.replace(",", ".");
        BigDecimal precoConvertido = new BigDecimal(preco);
        produtoModel.cadastraFerragem(new Ferragem(codigo, descricao, precoConvertido));
        model.addAttribute("pageTitle", "Cadastro Ferragem");
        return "redirect:/produto/get_listaFerragem";
    }

    @PostMapping("/alteraFerragem")
    public String altera(FerragemRecord ferragemRecord) {
        produtoModel.alteraFerragem(ferragemRecord);
        return "redirect:/produto/get_listaFerragem";
    }

    @PostMapping("/adicionarVidro")
    public String cadastroVidro(String nome, Long espessura, boolean isTemperado, boolean isLaminado, String preco) {
        produtoModel.cadastraVidro(nome, espessura, isTemperado, isLaminado, preco);
        return "redirect:/produto/get_listaVidro";
    }

    @PostMapping("/alteraVidro")
    public String alteraVidro(Long id, String nome, Long espessura, boolean isTemperado, boolean isLaminado, String preco) {
        produtoModel.alteraVidro(id, nome, espessura, isTemperado, isLaminado, preco);
        return "redirect:/produto/get_listaVidro";

    }

    @PostMapping("/adicionarPerfil")
    public String cadastroPerfil(PerfilRecord perfilRecord) {
        produtoModel.cadastraPerfil(perfilRecord);
        return "redirect:/produto/get_listaPerfil";
    }

    @PostMapping("/alteraPerfil")
    public String alteraPerfil(PerfilRecord perfilRecord) {
        produtoModel.alteraPerfil(perfilRecord);
        return "redirect:/produto/get_listaPerfil";
    }

    @GetMapping("/get_alteraFerragem")
    public String altera(@RequestParam("id") Long id, Model model) {
        model.addAttribute("pageTitle", "Lista de Ferragens");
        model.addAttribute("ferragem", produtoModel.buscaFerragem(id));
        return "/produto/formAlteraFerragem";
    }

    @GetMapping("/get_cadFerragem")
    public String formCadFerragem(Model model) {
        model.addAttribute("pageTitle", "Cadastro Ferragem");
        return "/produto/formCadastroFerragem";
    }

    @GetMapping("/get_listaFerragem")
    public String formListaFerragem(Model model) {
        model.addAttribute("listaFerragens", produtoModel.ferragens());
        model.addAttribute("pageTitle", "Lista de Ferragens");
        return "/produto/formListaFerragem";
    }

    @GetMapping("/get_cadVidro")
    public String formCadVidro(Model model) {
        model.addAttribute("pageTitle", "Cadastro Vidro");
        return "/produto/formCadastroVidro";
    }

    @GetMapping("/get_listaVidro")
    public String formListaVidros(Model model) {
        model.addAttribute("pageTitle", "Lista Vidros");
        model.addAttribute("listaVidros", produtoModel.vidros());
        return "/produto/formListaVidro";
    }

    @GetMapping("get_alteraVidro")
    public String formAltVidro(Long id, Model model) {
        model.addAttribute("pageTitle", "Altera Vidros");
        model.addAttribute("vidro", produtoModel.buscaVidro(id));
        return "/produto/formAlteraVidro";
    }

    @GetMapping("/get_cadPerfil")
    public String formCadPerfil(Model model) {
        model.addAttribute("pageTitle", "Cadastra Perfil");
        return "/produto/formCadastroPerfil";
    }

    @GetMapping("/get_alteraPerfil")
    public String formAltPerfil(Long id, Model model) {
        model.addAttribute("pageTitle", "Altera Perfil");
        model.addAttribute("perfil", produtoModel.buscaPerfil(id));
        return "/produto/formAlteraPerfil";
    }

    @GetMapping("get_listaPerfil")
    public String formListaPerfil(Model model) {
        model.addAttribute("pageTitle", "Lista Perfis");
        model.addAttribute("listaPerfil", produtoModel.perfis());
        return "/produto/formListaPerfil";
    }
}
