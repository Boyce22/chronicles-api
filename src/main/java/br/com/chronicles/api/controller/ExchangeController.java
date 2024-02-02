package br.com.chronicles.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.api.dto.AuthorDetailsDTO;
import br.com.chronicles.api.dto.ReaderChangeRequestDTO;
import br.com.chronicles.api.interfaces.IExchangeService;

@RequestMapping("/exchange")
@RestController
public class ExchangeController {
	
	
	private final IExchangeService exchangeService;
	
	public ExchangeController(IExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}
	
	@PutMapping("{id}")
	public AuthorDetailsDTO grantAuthorAccess(@PathVariable Long id, @RequestBody ReaderChangeRequestDTO dto) {
		return exchangeService.grantAuthorAccessToReader(id, dto);
	}

}