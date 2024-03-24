package br.com.chronicles.interfaces;

import br.com.chronicles.enuns.BookGenres;
import br.com.chronicles.enuns.BookMatureGenres;

public interface BookServiceImpl {

	BookGenres[] getGenres();

	BookMatureGenres[] getMatureGenres();

}
