package com.estdois.proseando.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estdois.proseando.entity.Usr;

@Repository
public interface UsrRepository extends CrudRepository<Usr, Long> {
    //User findByNome (String nome);

}
