package br.com.chronicles.service;

import java.util.List;

import br.com.chronicles.interfaces.ReaderService;
import org.springframework.stereotype.Service;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import br.com.chronicles.model.response.ReaderDetailsDTO;
import br.com.chronicles.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService {

	private final ReaderRepository readerRepository;

	public ReaderServiceImpl(ReaderRepository readerRepository) {
		this.readerRepository = readerRepository;
	}

	@Override
	public List<ReaderDetailsDTO> findAll() {
		return readerRepository.findAllActive().stream().map(ReaderDetailsDTO::new).toList();
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
		return new ReaderDetailsDTO(readerRepository.save(findById(id).update(dto)));
	}

	@Override
	public ReaderDetailsDTO register(ReaderRegisterDTO dto) {
		return new ReaderDetailsDTO(readerRepository.save(Reader.create().register(dto)));
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
