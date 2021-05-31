package com.estdois.proseando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
    public String telaPincipal(){
        return "home";
    }
	
	@RequestMapping("/entrar")
    public String login(){
        return "entrar";
    }

}
