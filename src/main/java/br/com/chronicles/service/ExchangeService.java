package br.com.chronicles.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.IAuthorService;
import br.com.chronicles.interfaces.IExchangeService;
import br.com.chronicles.interfaces.IReaderService;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.AuthorDetailsDTO;
import jakarta.transaction.Transactional;

@Service
public class ExchangeService implements IExchangeService {

	private final IAuthorService authorService;

	private final IReaderService readerService;

	public ExchangeService(IAuthorService authorService, IReaderService readerService) {
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
