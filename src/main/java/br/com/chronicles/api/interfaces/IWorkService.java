package br.com.chronicles.api.interfaces;

import br.com.chronicles.api.model.request.WorkCreateDTO;
import br.com.chronicles.api.model.response.WorkDetailsDTO;

public interface IWorkService {
	
	WorkDetailsDTO create(WorkCreateDTO dto);

}
