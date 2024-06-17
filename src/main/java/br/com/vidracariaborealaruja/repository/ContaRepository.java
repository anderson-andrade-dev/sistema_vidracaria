/**
 * Autor: Anderson Andrade:.
 * Data Criação: 26 de mar. de 2024
 */
package br.com.vidracariaborealaruja.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.vidracariaborealaruja.entity.Conta;

/**
 *
 */
public interface ContaRepository extends CrudRepository<Conta, Long> {

}
