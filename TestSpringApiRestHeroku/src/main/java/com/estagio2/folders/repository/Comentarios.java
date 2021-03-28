package com.estagio2.folders.repository; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estagio2.folders.model.Comentario;
import com.estagio2.folders.model.Usuario;

public interface Comentarios extends JpaRepository<Comentario, Long> {


}
