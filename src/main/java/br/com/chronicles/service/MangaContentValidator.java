package br.com.chronicles.service;

import br.com.chronicles.interfaces.GenreServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.entity.MangaGenre;
import br.com.chronicles.model.request.WorkCreateDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MangaContentValidator implements ValidatorGenresImpl {

    private final GenreServiceImpl genreService;

    public MangaContentValidator(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @Override
    public boolean validator(WorkCreateDTO dto) {
        List<MangaGenre> genres = Arrays.stream(dto.mangaGenres())
                .map(genreService::findGenreMangaById)
                .toList();

        return genres.stream().anyMatch(Genre::isMature);
    }

}
