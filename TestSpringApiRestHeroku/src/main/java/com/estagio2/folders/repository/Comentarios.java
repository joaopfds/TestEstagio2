package com.estagio2.folders.repository; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.estagio2.folders.model.Comentario;

public interface Comentarios extends JpaRepository<Comentario, Long> {

}
