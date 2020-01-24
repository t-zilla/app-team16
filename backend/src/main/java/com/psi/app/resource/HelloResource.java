package com.psi.app.resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloResource {

	@RequestMapping("/api/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
