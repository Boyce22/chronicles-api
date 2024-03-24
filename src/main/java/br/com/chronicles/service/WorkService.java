package br.com.chronicles.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.repository.WorkRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkService implements WorkServiceImpl {

	private final WorkRepository workRepository;

	private final AuthorServiceImpl authorService;

	private final FileServiceImpl fileService;

	private final List<ValidatorGenresImpl> validatorGenres;

	public WorkService(WorkRepository workRepository, AuthorServiceImpl authorService, FileServiceImpl fileService,
			List<ValidatorGenresImpl> validatorGenres) {
		this.workRepository = workRepository;
		this.authorService = authorService;
		this.fileService = fileService;
		this.validatorGenres = validatorGenres;
	}

	@Override
	public WorkDetailsDTO create(WorkCreateDTO dto, MultipartFile pdf) throws IOException {
		Author author = authorService.findById(dto.authorId());
		FileWork file = fileService.save(pdf);

		boolean isMature = validatorGenres.stream().map(validator -> validator.validator(dto))
				.anyMatch(validated -> validated);

		return new WorkDetailsDTO(workRepository.save(Work.create(dto, author, file, isMature)));
	}

	@Override
	public Work findById(Long id) {
		return workRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Work not found with ID: " + id));
	}
}
