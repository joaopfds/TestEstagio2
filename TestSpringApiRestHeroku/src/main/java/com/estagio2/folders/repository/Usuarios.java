package com.estagio2.folders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estagio2.folders.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
