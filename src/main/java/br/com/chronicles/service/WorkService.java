package br.com.chronicles.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.repository.WorkRepository;

@Service
public class WorkService implements WorkServiceImpl {

	private final WorkRepository workRepository;

	private final AuthorServiceImpl authorService;

	private final FileServiceImpl fileService;

	public WorkService(WorkRepository workRepository, AuthorServiceImpl authorService, FileServiceImpl fileService) {
		this.workRepository = workRepository;
		this.authorService = authorService;
		this.fileService = fileService;
	}

	@Override
	public WorkDetailsDTO create(WorkCreateDTO dto, MultipartFile pdf) throws IOException {
		Author author = authorService.findById(dto.authorId());
		return new WorkDetailsDTO(workRepository.save(new Work().create(dto, author, fileService.save(pdf))));
	}

}
