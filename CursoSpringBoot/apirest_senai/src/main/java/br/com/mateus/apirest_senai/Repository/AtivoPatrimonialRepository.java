package br.com.mateus.apirest_senai.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.mateus.apirest_senai.Model.AtivoPatrimonial;

public interface AtivoPatrimonialRepository extends CrudRepository<AtivoPatrimonial,Long> {
    
}
