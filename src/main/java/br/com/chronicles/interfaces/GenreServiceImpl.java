package br.com.chronicles.interfaces;

import br.com.chronicles.model.entity.BookGenre;
import br.com.chronicles.model.entity.MangaGenre;
import br.com.chronicles.model.request.GenreRegisterWithListDTO;
import br.com.chronicles.model.response.GenreDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface GenreServiceImpl {

    List<GenreDetailsDTO> registerMangaGenre(GenreRegisterWithListDTO dto);

    List<GenreDetailsDTO> registerBookGenre(GenreRegisterWithListDTO dto);

    List<GenreDetailsDTO> getMangaGenres();

    List<GenreDetailsDTO> getMangaMatureGenres();

    List<GenreDetailsDTO> getBookGenres();

    List<GenreDetailsDTO> getBookMatureGenres();

    BookGenre findGenreBookById(UUID id);

    MangaGenre findGenreMangaById(UUID id);
}
