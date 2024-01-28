package br.com.chronicles.api.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.api.security.dto.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginForm form){
		if(form.email().equals("email@email.com")) {			
			return ResponseEntity.ok("Ok");
		}
		return ResponseEntity.badRequest().body("null");
	}
}
