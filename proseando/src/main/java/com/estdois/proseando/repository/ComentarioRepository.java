package com.estdois.proseando.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estdois.proseando.entity.Comentario;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
    @Query("SELECT c FROM Comentario c left join Post p on (p.id = c.post.id) ")
    List<Comentario> findComentarios();
}
