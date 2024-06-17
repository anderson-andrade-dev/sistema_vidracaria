/**
 * Autor: Anderson Andrade:.
 * Data Criação: 28 de mar. de 2024
 */
package br.com.vidracariaborealaruja.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vidracariaborealaruja.entity.Cliente;
import br.com.vidracariaborealaruja.record.ClienteRecord;
import br.com.vidracariaborealaruja.repository.ClienteRepository;

/**
 *
 */
@Component
public class ClienteModel {

    @Autowired
    private ClienteRepository repository;

    public void cadastra(ClienteRecord cliente) {
        repository.save(new Cliente(cliente));
    }

    /**
     * @return
     */
    public List<Cliente> clientes() {
        return (List<Cliente>) repository.findAll();
    }

    /**
     * @param id
     * @return
     */
    public Cliente busca(Long id) {
        return repository.findById(id).get();
    }

    /**
     * @param cliente
     * @param id
     */
    public void altera(ClienteRecord cliente, Long id) {
        repository.findById(id).ifPresent(c -> {
                    c.atualiza(cliente);
                    repository.save(c);
                }

        );

    }

}
