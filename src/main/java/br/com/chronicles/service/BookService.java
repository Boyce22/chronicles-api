package br.com.chronicles.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.enuns.BookGenres;
import br.com.chronicles.enuns.BookMatureGenres;
import br.com.chronicles.interfaces.BookServiceImpl;

@Service
public class BookService implements BookServiceImpl {

	@Override
	public BookGenres[] getGenres() {
		return BookGenres.values();
	}

	@Override
	public BookMatureGenres[] getMatureGenres() {
		return BookMatureGenres.values();
	}

}
