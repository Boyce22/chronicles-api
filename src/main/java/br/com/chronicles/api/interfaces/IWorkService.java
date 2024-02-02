package br.com.chronicles.api.interfaces;

import br.com.chronicles.api.dto.WorkCreateDTO;
import br.com.chronicles.api.dto.WorkDetailsDTO;

public interface IWorkService {
	
	WorkDetailsDTO create(WorkCreateDTO dto);

}
