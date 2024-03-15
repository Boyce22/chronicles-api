package br.com.chronicles.service;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.interfaces.ExchangeServiceImpl;
import br.com.chronicles.interfaces.ReaderServiceImpl;
import org.springframework.stereotype.Service;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;
import jakarta.transaction.Transactional;

@Service
public class ExchangeService implements ExchangeServiceImpl {

	private final AuthorServiceImpl authorService;

	private final ReaderServiceImpl readerService;

	public ExchangeService(AuthorServiceImpl authorService, ReaderServiceImpl readerService) {
		this.authorService = authorService;
		this.readerService = readerService;
	}

	@Override
	@Transactional
	public AuthorDetailsDTO grantAuthorAccessToReader(Long id, ReaderChangeRequestDTO dto) {
		Reader reader = findById(id);
		AuthorDetailsDTO author = authorService.grantAuthorAccess(reader, dto);
		readerService.deletePermanently(id);
		return author;
	}

	private Reader findById(Long readerId) {
		return readerService.findById(readerId);
	}

}
