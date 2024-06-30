package br.com.chronicles.service;

import br.com.chronicles.interfaces.*;
import br.com.chronicles.model.entity.*;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.model.response.WorkNonWithChapters;
import br.com.chronicles.model.response.WorkRegisterDetails;
import br.com.chronicles.repository.WorkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    private final CollaboratorService collaboratorService;

    private final FileService fileService;

    private final List<ValidatorGenres> validatorGenres;

    private final GenreService genreService;

    private final ChapterService chapterService;

    public WorkServiceImpl(WorkRepository workRepository, CollaboratorServiceImpl collaboratorService, FileServiceImpl fileService,
                           List<ValidatorGenres> validatorGenres, GenreServiceImpl genreService, ChapterServiceImpl chapterService) {
        this.workRepository = workRepository;
        this.collaboratorService = collaboratorService;
        this.fileService = fileService;
        this.validatorGenres = validatorGenres;
        this.genreService = genreService;
        this.chapterService = chapterService;
    }

    @Override
    public WorkRegisterDetails create(WorkCreateDTO dto, MultipartFile pdf, MultipartFile cover) throws IOException {
        Collaborator collaborator = collaboratorService.findById(dto.collaboratorId());

        List<? extends Genre> genres = dto.bookGenres() != null
                ? getBookGenres(dto.bookGenres())
                : getMangaGenres(dto.mangaGenres());

        FileWork file = fileService.save(pdf);
        Chapter chapter = chapterService.save(file, dto.title(), dto.description());

        boolean isMature = validatorGenres.stream()
                .anyMatch(validator -> validator.validator(dto, genres));

        Work work = workRepository.save(Work.builder()
                .withTitle(dto.title())
                .withDescription(dto.description())
                .withCollaborator(collaborator)
                .withFile(file)
                .withCover(cover.getBytes())
                .withGenres(genres)
                .withIsMature(isMature)
                .build()
        );

        return new WorkRegisterDetails(work);
    }

    @Override
    public List<WorkNonWithChapters> findAll() {
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
