package com.estagio2.folders.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagio2.folders.model.Comentario;

@Repository
public interface Comentarios extends JpaRepository<Comentario, Long> {

}
