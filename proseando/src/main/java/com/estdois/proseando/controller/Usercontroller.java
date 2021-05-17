package com.estdois.proseando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estdois.proseando.entity.User;
import com.estdois.proseando.repository.UserRepository;

@Controller
public class Usercontroller {
	 @Autowired
	    UserRepository usuarioRepository;

	    @RequestMapping("/usuario")
	    public String listarUsuarios(Model model){
	        model.addAttribute( "user", usuarioRepository.findAll());
	        return "listaDeUser";
	    }

	    @GetMapping("/usuario/add")
	    public String usuarioForm(Model model){
	        model.addAttribute("user", new User());
	        return "usuarioForm";
	    }

	    @PostMapping("/usuario/process")
	    public String processFrom(@Validated User usuario, BindingResult result){
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
