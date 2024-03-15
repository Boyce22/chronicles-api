package br.com.chronicles.service;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.interfaces.WorkServiceImpl;
import org.springframework.stereotype.Service;

import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.repository.WorkRepository;

@Service
public class WorkService implements WorkServiceImpl {

	private final WorkRepository workRepository;

	private final AuthorServiceImpl authorService;

	public WorkService(WorkRepository workRepository, AuthorServiceImpl authorService) {
		this.workRepository = workRepository;
		this.authorService = authorService;
	}

	@Override
	public WorkDetailsDTO create(WorkCreateDTO dto) {
		Author author = authorService.findById(dto.authorId());
		return new WorkDetailsDTO(workRepository.save(new Work().create(dto, author)));
	}

}
