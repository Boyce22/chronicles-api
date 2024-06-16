package br.com.chronicles.controller;

import br.com.chronicles.interfaces.GenreServiceImpl;
import br.com.chronicles.model.request.GenreRegisterWithListDTO;
import br.com.chronicles.model.response.GenreDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {

    private final GenreServiceImpl genreService;

    public GenresController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @GetMapping("manga/all")
    public ResponseEntity<List<GenreDetailsDTO>> getAllGenres() {
        List<GenreDetailsDTO> genres = genreService.getMangaGenres();
        return !genres.isEmpty() ? ResponseEntity.ok(genres) : ResponseEntity.notFound().build();
    }

    @GetMapping("manga/mature/all")
    public ResponseEntity<List<GenreDetailsDTO>> getAllMatureGenres() {
        List<GenreDetailsDTO> genres = genreService.getMangaMatureGenres();
        return !genres.isEmpty() ? ResponseEntity.ok(genres) : ResponseEntity.notFound().build();
    }

    @GetMapping("book/all")
    public ResponseEntity<List<GenreDetailsDTO>> getAllBookGenres() {
        List<GenreDetailsDTO> genres = genreService.getBookGenres();
        return !genres.isEmpty() ? ResponseEntity.ok(genres) : ResponseEntity.notFound().build();
    }

    @GetMapping("book/mature/all")
    public ResponseEntity<List<GenreDetailsDTO>> getAllMatureBookGenres() {
        List<GenreDetailsDTO> genres = genreService.getBookMatureGenres();
        return !genres.isEmpty() ? ResponseEntity.ok(genres) : ResponseEntity.notFound().build();
    }

    @PostMapping("book/register")
    public ResponseEntity<List<GenreDetailsDTO>> registerBookGenres(@RequestBody GenreRegisterWithListDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.registerBookGenre(dto));
    }

    @PostMapping("manga/register")
    public ResponseEntity<List<GenreDetailsDTO>> registerMangaGenres(@RequestBody GenreRegisterWithListDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.registerMangaGenre(dto));
    }

}
