package br.com.chronicles.api.interfaces;

import java.util.List;

import br.com.chronicles.api.dto.ReaderDetailsDTO;
import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.dto.ReaderUpdateDTO;

public interface IReaderService {

	ReaderDetailsDTO register(ReaderRegisterDTO dto);
	
	ReaderDetailsDTO update(ReaderUpdateDTO dto, Long id);

	List<ReaderDetailsDTO> findAll();

	void delete(Long id);
	
	void active(Long id);

}