package br.com.chronicles.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.ReaderDetailsDTO;
import br.com.chronicles.api.dto.ReaderUpdateDTO;
import br.com.chronicles.api.entity.Reader;
import br.com.chronicles.api.interfaces.IReaderService;
import br.com.chronicles.api.repository.ReaderRepository;

@Service
public class ReaderService implements IReaderService {

	private final ReaderRepository readerRepository;

	public ReaderService(ReaderRepository readerRepository) {
		this.readerRepository = readerRepository;
	}

	@Override
	public List<ReaderDetailsDTO> findAll() {
		return readerRepository.findAllActive().stream().map(ReaderDetailsDTO::new).collect(Collectors.toList());
	}
	
	@Override
	public void delete(Long id) {
		readerRepository.save(findById(id).disable());
	}
	
	@Override
	public void deletePermanently(Long id) {
		readerRepository.delete(findById(id).disable());
	}


	@Override
	public ReaderDetailsDTO update(ReaderUpdateDTO dto, Long id) {
		return new ReaderDetailsDTO(readerRepository.save(findById(id).atualizar(dto)));
	}
	
	@Override
	public void active(Long id) {
		readerRepository.save(findById(id).active());
	}
	
	@Override
	public Reader findById(Long id) {
		return readerRepository.findById(id).orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
	}

}
