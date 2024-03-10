package br.com.chronicles.interfaces;

import java.util.List;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import br.com.chronicles.model.response.ReaderDetailsDTO;

public interface IReaderService {
	
	ReaderDetailsDTO update(ReaderUpdateDTO dto, Long id);

	List<ReaderDetailsDTO> findAll();

	void delete(Long id);
	
	void active(Long id);
	
	Reader findById(Long id);

	void deletePermanently(Long id);

	ReaderDetailsDTO register(ReaderRegisterDTO dto);

}
