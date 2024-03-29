package br.com.chronicles.controller;

import br.com.chronicles.interfaces.ExchangeServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;

@RequestMapping("/exchange")
@RestController
public class ExchangeController {
	
	private final ExchangeServiceImpl exchangeService;
	
	public ExchangeController(ExchangeServiceImpl exchangeService) {
		this.exchangeService = exchangeService;
	}
	
	@PutMapping("/{id}")
	public AuthorDetailsDTO grantAuthorAccess(@PathVariable Long id, @RequestBody ReaderChangeRequestDTO dto) {
		return exchangeService.grantAuthorAccessToReader(id, dto);
	}

}
