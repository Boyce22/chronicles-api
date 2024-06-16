package br.com.chronicles.service;

import br.com.chronicles.interfaces.GenreServiceImpl;
import br.com.chronicles.model.entity.BookGenre;
import br.com.chronicles.model.entity.MangaGenre;
import br.com.chronicles.model.request.GenreRegisterWithListDTO;
import br.com.chronicles.model.response.GenreDetailsDTO;
import br.com.chronicles.repository.BookGenreRepository;
import br.com.chronicles.repository.MangaGenreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class GenreService implements GenreServiceImpl {

    private final MangaGenreRepository mangaGenreRepository;

    private final BookGenreRepository bookGenreRepository;

    public GenreService(MangaGenreRepository mangaGenreRepository, BookGenreRepository bookGenreRepository) {
        this.mangaGenreRepository = mangaGenreRepository;
        this.bookGenreRepository = bookGenreRepository;
    }

    @Override
    public List<GenreDetailsDTO> registerMangaGenre(GenreRegisterWithListDTO dto) {
        if (dto.genres() != null && !dto.genres().isEmpty()) {

            List<MangaGenre> genres = dto
                    .genres()
                    .stream()
                    .map(gen -> MangaGenre.create().register(gen.name(), gen.description()))
                    .toList();

            mangaGenreRepository.saveAll(genres);
            return genres.stream().map(GenreDetailsDTO::new).toList();
        }
        return Collections.singletonList(new GenreDetailsDTO(mangaGenreRepository.save(MangaGenre.create().register(dto.name(), dto.description()))));
    }

    @Override
    public List<GenreDetailsDTO> registerBookGenre(GenreRegisterWithListDTO dto) {
        if (dto.genres() != null && !dto.genres().isEmpty()) {

            List<BookGenre> genres = dto
                    .genres()
                    .stream()
                    .map(gen -> BookGenre.create().register(gen.name(), gen.description()))
                    .toList();

            bookGenreRepository.saveAll(genres);
            return genres.stream().map(GenreDetailsDTO::new).toList();
        }
        return Collections.singletonList(new GenreDetailsDTO(bookGenreRepository.save(BookGenre.create().register(dto.name(), dto.description()))));
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
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encotrado"));
    }

    @Override
    public MangaGenre findGenreMangaById(UUID id) {
        return mangaGenreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encotrado"));
    }
}
