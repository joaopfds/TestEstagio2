package com.estdois.leriando.persistence;

import com.estdois.leriando.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {



}
