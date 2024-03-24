package br.com.chronicles.interfaces;

import br.com.chronicles.enuns.MangaGenres;
import br.com.chronicles.enuns.MangaMatureGenres;

public interface MangaServiceImpl {

	MangaMatureGenres[] getMatureGenres();

	MangaGenres[] getGenres();

}
