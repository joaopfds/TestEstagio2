package com.estdois.leriando.persistence;


import com.estdois.leriando.entity.Comentario;
import com.estdois.leriando.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT c FROM Comentario c")
    List<Comentario> findComentarios();

    @Query("SELECT p FROM Post p where p.tipo like '%ca' ")
    List<Post> findPostMat();

    @Query("SELECT p FROM Post p where p.tipo like '%ues' ")
    List<Post> findPostPt();

    @Query("SELECT p FROM Post p where p.tipo like '%lês' ")
    List<Post> findPostEng();

    @Query("SELECT p FROM Post p where p.tipo like '%ol' ")
    List<Post> findPostEsp();

    @Query("SELECT p FROM Post p where p.tipo like '%ria' ")
    List<Post> findPostHist();

    @Query("SELECT p FROM Post p where p.tipo like '%fia' ")
    List<Post> findPostGeo();

    @Query("SELECT p FROM Post p where p.tipo like '%cias' ")
    List<Post> findPostBiol();

    @Query("SELECT p FROM Post p where p.tipo like '%o' ")
    List<Post> findPostRedacao();



}
