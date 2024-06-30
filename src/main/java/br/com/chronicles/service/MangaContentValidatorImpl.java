package br.com.chronicles.service;

import br.com.chronicles.interfaces.ValidatorGenres;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.request.WorkCreateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaContentValidatorImpl implements ValidatorGenres {

    @Override
    public boolean validator(WorkCreateDTO dto, List<? extends Genre> genres) {
        return dto.mangaGenres() != null && genres.stream().anyMatch(Genre::isMature);
    }

}
