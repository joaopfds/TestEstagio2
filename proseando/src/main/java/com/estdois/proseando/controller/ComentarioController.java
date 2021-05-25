package com.estdois.proseando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estdois.proseando.entity.Comentario;
import com.estdois.proseando.repository.ComentarioRepository;

@Controller
public class ComentarioController {

    @Autowired
    ComentarioRepository comentarioRepository;

    @RequestMapping("/coment")
    public String listarComentarios(Model model){
        model.addAttribute("comentarios", comentarioRepository.findAll());
        return "listaDeComentarios";
    }

    @RequestMapping("/coment/add")
    public String addComentario(Model model){
        model.addAttribute("comentario", new Comentario());
        return "comentForm";
    }

    @RequestMapping("/coment/process")
    public String processFrom(@Validated Comentario comentario, BindingResult result){
        if (result.hasErrors()){
            return "comentForm";
        }
        if (comentario.getText() != ""){
            comentarioRepository.save(comentario);
            return "redirect:/coment";
        }else{
            return "comentForm";
        }
    }
}
