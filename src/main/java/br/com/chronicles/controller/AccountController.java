package br.com.chronicles.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.interfaces.AccountServiceImpl;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;

@RestController
@RequestMapping("/account")
public class AccountController {

	private final AccountServiceImpl accountService;

	public AccountController(AccountServiceImpl accountService) {
		this.accountService = accountService;
	}

	@PutMapping("/{id}")
	public CollaboratorDetailsDTO grantAuthorAccess(@PathVariable Long id, @RequestBody ReaderChangeRequestDTO dto) {
		return accountService.grantAuthorAccessToReader(id, dto);
	}

}
