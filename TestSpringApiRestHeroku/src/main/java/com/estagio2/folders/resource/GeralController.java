package com.estagio2.folders.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GeralController {
	
	@RequestMapping("/ab")
	private String homeapp() {
		return "cadastro" ;

	}
	
	@RequestMapping("/")
	private String homeap() {
		return "index" ;

	}

}
