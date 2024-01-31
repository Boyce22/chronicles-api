package br.com.chronicles.api.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.WorkCreateDTO;
import br.com.chronicles.api.dto.WorkDetailsDTO;
import br.com.chronicles.api.entity.Author;
import br.com.chronicles.api.entity.Work;
import br.com.chronicles.api.interfaces.IAuthorService;
import br.com.chronicles.api.interfaces.IWorkService;
import br.com.chronicles.api.repository.WorkRepository;

@Service
public class WorkService implements IWorkService {

	private final WorkRepository workRepository;

	private final IAuthorService authorService;

	public WorkService(WorkRepository workRepository, IAuthorService authorService) {
		this.workRepository = workRepository;
		this.authorService = authorService;
	}

	public WorkDetailsDTO create(WorkCreateDTO dto) {
		Author author = authorService.findById(dto.authorId());
		return new WorkDetailsDTO(workRepository.save(new Work().create(dto, author)));
	}

}
