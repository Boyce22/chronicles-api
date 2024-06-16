package br.com.chronicles.service;

import br.com.chronicles.interfaces.AuthorServiceImpl;
import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.interfaces.ValidatorGenresImpl;
import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.entity.Author;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.repository.WorkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

        boolean isMature = validatorGenres.stream().anyMatch(validator -> validator.validator(dto));

        Work work = workRepository.save(Work.create().register(dto, author, file, isMature));

        List<String> genres = !work.getBookGenres().isEmpty() ?
                work.getBookGenres().stream().map(Genre::getName).toList()
                :
                work.getMangaGenres().stream().map(Genre::getName).toList();

        return new WorkDetailsDTO(work, genres);
    }

    @Override
    public Work findById(Long id) {
        return workRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Work not found with ID: " + id));
    }
}
