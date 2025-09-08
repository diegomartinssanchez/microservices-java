package br.edu.atitus.greeting_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.greeting_service.configs.GreetingConfig;
import br.edu.atitus.greeting_service.dto.GreetingRequest;

@RestController
@RequestMapping("greeting")
public class GreetingController {
	
	private final GreetingConfig config;
	
	public GreetingController(GreetingConfig config) {
		super();
		this.config = config;
	}

	// Suporta: /greeting e /greeting?name=Chewbacca
	@GetMapping
	public ResponseEntity<String> greet(@RequestParam(required = false) String name) {
		String greetingReturn = config.getGreeting();
		String nameReturn = name != null ? name : config.getDefaultName();
		String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
		
		return ResponseEntity.ok(textReturn);
	}

	// Suporta: /greeting/Chewbacca
	@GetMapping("/{name}")
	public ResponseEntity<String> greetWithPathVariable(@PathVariable String name) {
		String greetingReturn = config.getGreeting();
		String textReturn = String.format("%s, %s!!!", greetingReturn, name);
		
		return ResponseEntity.ok(textReturn);
	}

	// Suporta: POST /greeting com JSON { "name": "Leia" }
	@PostMapping
	public ResponseEntity<String> greetPost(@RequestBody GreetingRequest request) {
		String greetingReturn = config.getGreeting();
		String nameReturn = request.getName() != null ? request.getName() : config.getDefaultName();
		String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
		
		return ResponseEntity.ok(textReturn);
	}
}
