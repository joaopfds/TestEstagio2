package com.estdois.leriando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String telaPincipal(){
        return "home";
    }

    @RequestMapping("/login")
    public String Logar(){
        return "login";
    }
}
