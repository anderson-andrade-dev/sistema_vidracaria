package br.com.vidracariaborealaruja.repository;

import br.com.vidracariaborealaruja.entity.Ferragem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FerragemRepository extends CrudRepository<Ferragem, Long> {
    @Query("select f from Ferragem f where f.codigo = ?1")
    public Ferragem findByCodigo(String codigo);
}
