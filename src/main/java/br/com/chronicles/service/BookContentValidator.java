package br.com.chronicles.service;

import br.com.chronicles.interfaces.GenreServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.model.entity.BookGenre;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.request.WorkCreateDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookContentValidator implements ValidatorGenresImpl {
    private final GenreServiceImpl genreService;

    public BookContentValidator(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @Override
    public boolean validator(WorkCreateDTO dto) {
        List<BookGenre> genres = Arrays.stream(dto.bookGenres())
                .map(genreService::findGenreBookById)
                .toList();

        return genres.stream().anyMatch(Genre::isMature);
    }

}
