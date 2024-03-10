package br.com.chronicles.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.IAuthorService;
import br.com.chronicles.interfaces.IWorkService;
import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.repository.WorkRepository;

@Service
public class WorkService implements IWorkService {

	private final WorkRepository workRepository;

	private final IAuthorService authorService;

	public WorkService(WorkRepository workRepository, IAuthorService authorService) {
		this.workRepository = workRepository;
		this.authorService = authorService;
	}

	@Override
	public WorkDetailsDTO create(WorkCreateDTO dto) {
		Author author = authorService.findById(dto.authorId());
		return new WorkDetailsDTO(workRepository.save(new Work().create(dto, author)));
	}

}
