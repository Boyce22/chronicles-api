package br.com.chronicles.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.chronicles.enuns.BookMatureGenres;
import br.com.chronicles.interfaces.BookServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.model.request.WorkCreateDTO;

@Service
public class BookContentValidator implements ValidatorGenresImpl {

	private final BookServiceImpl bookService;

	public BookContentValidator(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	@Override
	public boolean validator(WorkCreateDTO dto) {
		BookMatureGenres[] booksGenresEnum = bookService.getMatureGenres();
		List<String> booksGenres = Arrays.stream(booksGenresEnum).map(BookMatureGenres::toString).toList();

		return Arrays.stream(dto.genre()).anyMatch(booksGenres::contains);
	}

}
