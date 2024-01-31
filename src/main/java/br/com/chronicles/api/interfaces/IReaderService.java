package br.com.chronicles.api.interfaces;

import java.util.List;

import br.com.chronicles.api.dto.ReaderDetailsDTO;
import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.dto.ReaderUpdateDTO;

public interface IReaderService {

	List<ReaderDetailsDTO> findAll();

	ReaderDetailsDTO register(ReaderRegisterDTO dto);

	ReaderDetailsDTO update(ReaderUpdateDTO dto, Long id);

	void delete(Long id);
	
	void active(Long id);

}
