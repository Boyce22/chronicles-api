package br.com.chronicles.service;

import br.com.chronicles.interfaces.GenreService;
import br.com.chronicles.model.entity.BookGenre;
import br.com.chronicles.model.entity.MangaGenre;
import br.com.chronicles.model.request.GenreRegisterWithListDTO;
import br.com.chronicles.model.response.GenreDetailsDTO;
import br.com.chronicles.repository.BookGenreRepository;
import br.com.chronicles.repository.MangaGenreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenreServiceImpl implements GenreService {

    private final MangaGenreRepository mangaGenreRepository;

    private final BookGenreRepository bookGenreRepository;

    public GenreServiceImpl(MangaGenreRepository mangaGenreRepository, BookGenreRepository bookGenreRepository) {
        this.mangaGenreRepository = mangaGenreRepository;
        this.bookGenreRepository = bookGenreRepository;
    }

    @Override
    public List<GenreDetailsDTO> registerMangaGenres(GenreRegisterWithListDTO dto) {
        List<MangaGenre> genres = dto
                .genres()
                .stream()
                .map(gen -> MangaGenre
                        .builder()
                        .withDescription(gen.description())
                        .withName(gen.name())
                        .build())
                .toList();

        return mangaGenreRepository.saveAll(genres).stream().map(GenreDetailsDTO::new).toList();
    }

    @Override
    public List<GenreDetailsDTO> registerBookGenres(GenreRegisterWithListDTO dto) {
        List<BookGenre> genres = dto
                .genres()
                .stream()
                .map(gen -> BookGenre
                        .builder()
                        .withDescription(gen.description())
                        .withName(gen.name())
                        .build())
                .toList();

        return bookGenreRepository.saveAll(genres).stream().map(GenreDetailsDTO::new).toList();
    }

    @Override
    public List<GenreDetailsDTO> getMangaGenres() {
        return mangaGenreRepository
                .findNonMatureGenres()
                .stream()
                .map(GenreDetailsDTO::new)
                .toList();
    }

    @Override
    public List<GenreDetailsDTO> getMangaMatureGenres() {
        return mangaGenreRepository
                .findAllMatureGenres()
                .stream()
                .map(GenreDetailsDTO::new)
                .toList();
    }

    @Override
    public List<GenreDetailsDTO> getBookGenres() {
        return bookGenreRepository
                .findNonMatureGenres()
                .stream()
                .map(GenreDetailsDTO::new)
                .toList();
    }

    @Override
    public List<GenreDetailsDTO> getBookMatureGenres() {
        return bookGenreRepository
                .findAllMatureGenres()
                .stream()
                .map(GenreDetailsDTO::new)
                .toList();
    }

    @Override
    public BookGenre findGenreBookById(UUID id) {
        return bookGenreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));
    }

    @Override
    public MangaGenre findGenreMangaById(UUID id) {
        return mangaGenreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));
    }
}
