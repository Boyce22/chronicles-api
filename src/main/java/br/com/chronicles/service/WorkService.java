package br.com.chronicles.service;

import br.com.chronicles.interfaces.*;
import br.com.chronicles.model.entity.*;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.model.response.WorkNonWithFile;
import br.com.chronicles.repository.WorkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class WorkService implements WorkServiceImpl {

    private final WorkRepository workRepository;

    private final AuthorServiceImpl authorService;

    private final FileServiceImpl fileService;

    private final List<ValidatorGenresImpl> validatorGenres;

    private final GenreServiceImpl genreService;

    public WorkService(WorkRepository workRepository, AuthorServiceImpl authorService, FileServiceImpl fileService,
                       List<ValidatorGenresImpl> validatorGenres, GenreServiceImpl genreService) {
        this.workRepository = workRepository;
        this.authorService = authorService;
        this.fileService = fileService;
        this.validatorGenres = validatorGenres;
        this.genreService = genreService;
    }

    @Override
    public WorkDetailsDTO create(WorkCreateDTO dto, MultipartFile pdf) throws IOException {
        Author author = authorService.findById(dto.authorId());

        List<? extends Genre> genres = dto.bookGenres() != null
                ? getBookGenres(dto.bookGenres())
                : getMangaGenres(dto.mangaGenres());

        FileWork file = fileService.save(pdf);

        boolean isMature = validatorGenres.stream()
                .anyMatch(validator -> validator.validator(dto, genres));

        Work work = workRepository.save(Work.create().register(dto, genres, author, file, isMature));

        return new WorkDetailsDTO(work);
    }

    @Override
    public List<WorkNonWithFile> findAll() {
        return workRepository.findAllWithFiles();
    }

    @Override
    public Work findById(Long id) {
        return workRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Work not found with ID: " + id));
    }

    @Override
    public WorkDetailsDTO findWorkDetailsById(Long id) {
        return new WorkDetailsDTO(findById(id));
    }

    private List<MangaGenre> getMangaGenres(UUID[] ids) {
        return Arrays.stream(ids)
                .map(genreService::findGenreMangaById)
                .toList();
    }

    private List<BookGenre> getBookGenres(UUID[] ids) {
        return Arrays.stream(ids)
                .map(genreService::findGenreBookById)
                .toList();
    }
}
