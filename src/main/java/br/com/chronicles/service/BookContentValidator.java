package br.com.chronicles.service;

import br.com.chronicles.interfaces.GenreServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.request.WorkCreateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookContentValidator implements ValidatorGenresImpl {

    @Override
    public boolean validator(WorkCreateDTO dto, List<? extends Genre> genres) {
        return dto.bookGenres().length != 0 && genres.stream().anyMatch(Genre::isMature);
    }

}
