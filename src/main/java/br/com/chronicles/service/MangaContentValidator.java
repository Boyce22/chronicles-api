package br.com.chronicles.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.chronicles.enuns.MangaMatureGenres;
import br.com.chronicles.interfaces.MangaServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.model.request.WorkCreateDTO;

@Service
public class MangaContentValidator implements ValidatorGenresImpl {
	
	private final MangaServiceImpl mangaService;

	public MangaContentValidator(MangaServiceImpl mangaService) {
		this.mangaService = mangaService;
	}

	@Override
	public boolean validator(WorkCreateDTO dto) {
		MangaMatureGenres[] mangaGenresEnum = mangaService.getMatureGenres();
		List<String> mangaGenres = Arrays.stream(mangaGenresEnum)
											.map(MangaMatureGenres::toString)
											.toList();
		
		return Arrays.stream(dto.genre()).anyMatch(mangaGenres::contains);
	}
	

}
