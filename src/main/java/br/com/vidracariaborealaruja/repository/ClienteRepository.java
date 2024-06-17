/**
 * Autor: Anderson Andrade:.
 * Data Criação: 5 de jan. de 2024
 */
package br.com.vidracariaborealaruja.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vidracariaborealaruja.entity.Cliente;

/**
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
