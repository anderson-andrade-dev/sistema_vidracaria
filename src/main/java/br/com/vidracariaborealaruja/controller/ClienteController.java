/**
 * Autor: Anderson Andrade:.
 * Data Criação: 5 de jan. de 2024
 */
package br.com.vidracariaborealaruja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vidracariaborealaruja.model.ClienteModel;
import br.com.vidracariaborealaruja.record.ClienteRecord;

/**
 *
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteModel clienteModel;


    @GetMapping
    public String formListaClientes(Model model) {
        model.addAttribute("listaClientes", clienteModel.clientes());
        model.addAttribute("pageTitle", "Clientes Cadastrados");
        return "formListaClientes";
    }

    @PostMapping
    public String cadastro(ClienteRecord cliente) {
        clienteModel.cadastra(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/g_cadastroCliente")
    public String formCadastro(Model model) {
        model.addAttribute("pageTitle", "Cadastrar Cliente");
        return "formCadastroCliente";
    }

    @GetMapping("/g_alterarCliente")
    public String formAlterar(Model model, Long id) {
        model.addAttribute("pageTitle", "Alterar Cliente");
        model.addAttribute("cliente", clienteModel.busca(id));
        return "formAlterarCliente";
    }

    @PostMapping("/alterar")
    public String alterar(ClienteRecord cliente, Long id) {
        clienteModel.altera(cliente, id);
        return "redirect:/cliente";
    }

}
