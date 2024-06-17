/**
 * Autor: Anderson Andrade:.
 * Data Criação: 23 de fev. de 2024
 */
package br.com.vidracariaborealaruja.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.vidracariaborealaruja.entity.Caixa;

/**
 *
 */
public interface CaixaRepository extends CrudRepository<Caixa, Long> {

    /**
     * @param data
     */
    @Query("select c from Caixa c where c.dataAbertura = ?1")
    public Caixa findByData(LocalDate data);


}
