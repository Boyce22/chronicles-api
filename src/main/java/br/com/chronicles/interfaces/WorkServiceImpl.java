package br.com.chronicles.interfaces;

import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;

public interface WorkServiceImpl {
	
	WorkDetailsDTO create(WorkCreateDTO dto);

}
