package com.estagio2.folders.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeralController {
	
	@RequestMapping("/")
	private String homeapp() {
		return "cadastro";

	}

}
