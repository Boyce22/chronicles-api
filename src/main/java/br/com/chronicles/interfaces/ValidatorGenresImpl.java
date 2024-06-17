package br.com.chronicles.interfaces;

import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.request.WorkCreateDTO;

import java.util.List;

public interface ValidatorGenresImpl {

    boolean validator(WorkCreateDTO dto, List<? extends Genre> genres);

}
