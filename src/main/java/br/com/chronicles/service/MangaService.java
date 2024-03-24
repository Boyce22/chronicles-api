package br.com.chronicles.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.enuns.MangaGenres;
import br.com.chronicles.enuns.MangaMatureGenres;
import br.com.chronicles.interfaces.MangaServiceImpl;

@Service
public class MangaService implements MangaServiceImpl {

	@Override
	public MangaGenres[] getGenres() {
		return MangaGenres.values();
	}

	@Override
	public MangaMatureGenres[] getMatureGenres() {
		return MangaMatureGenres.values();
	}

}
