package br.com.chronicles.api.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.api.security.entity.Role;
import br.com.chronicles.api.security.interfaces.IRoleService;

@RequestMapping
@RestController("/role")
public class RoleController {
	
	private final IRoleService roleService;
	
	public RoleController(IRoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Role role) {
	    return ResponseEntity.ok(roleService.register(role));
	}

}
