package com.estdois.proseando.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estdois.proseando.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByNome (String nome);

}
