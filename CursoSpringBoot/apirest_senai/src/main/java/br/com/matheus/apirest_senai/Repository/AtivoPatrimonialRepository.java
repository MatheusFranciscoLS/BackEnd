package br.com.matheus.apirest_senai.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matheus.apirest_senai.Model.AtivoPatrimonial;

public interface AtivoPatrimonialRepository extends CrudRepository<AtivoPatrimonial,Long> {
    
}

