package com.estagio2.folders.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.LoginAuthenticator;

@RestController
public class GeralController {
	
	@RequestMapping("/")
	private String homeapp() {
		return "cadastro";

	}

}
