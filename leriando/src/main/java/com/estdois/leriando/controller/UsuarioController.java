package com.estdois.leriando.controller;

import com.estdois.leriando.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estdois.leriando.persistence.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/usuario")
    public String listarUsuarios(Model model){
        model.addAttribute( "usuarios", usuarioRepository.findAll());
        return "list";
    }

    @GetMapping("/usuario/add")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarioForm";
    }

    @PostMapping("/usuario/process")
    public String processFrom(@Validated Usuario usuario, BindingResult result){
        if (result.hasErrors()){
            return "usuarioForm";
        }

        if (usuario.getSenha() != ""){
            usuarioRepository.save(usuario);
            return "redirect:/usuario";
        }else {
            return "usuarioForm";
        }

    }
}

