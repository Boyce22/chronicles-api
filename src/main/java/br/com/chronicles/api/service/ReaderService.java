package br.com.chronicles.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.ReaderDetailsDTO;
import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.dto.ReaderUpdateDTO;
import br.com.chronicles.api.entity.Reader;
import br.com.chronicles.api.interfaces.IReaderService;
import br.com.chronicles.api.repository.ReaderRepository;
import br.com.chronicles.api.security.interfaces.IUserService;

@Service
public class ReaderService implements IReaderService {

	private final ReaderRepository readerRepository;
	
	private final IUserService userService;

	public ReaderService(ReaderRepository readerRepository, IUserService userService) {
		this.readerRepository = readerRepository;
		this.userService = userService;
	}

	@Override
	public List<ReaderDetailsDTO> findAll() {
		return readerRepository.findAllActive().stream().map(ReaderDetailsDTO::new).collect(Collectors.toList());
	}

	@Override
	public ReaderDetailsDTO register(ReaderRegisterDTO dto) {
		return new ReaderDetailsDTO(readerRepository.save(new Reader().registrar(dto, userService.createUserWithReader(dto))));
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
