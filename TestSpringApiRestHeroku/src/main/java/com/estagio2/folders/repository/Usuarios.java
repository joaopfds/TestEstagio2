package com.estagio2.folders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagio2.folders.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long> {

}
