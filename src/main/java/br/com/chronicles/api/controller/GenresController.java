package br.com.chronicles.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.api.enuns.BookGenres;
import br.com.chronicles.api.enuns.MangaGenres;
import br.com.chronicles.api.enuns.MangaMatureGenres;
import br.com.chronicles.api.enuns.MatureBookGenres;

@RestController
@RequestMapping("/genres")
public class GenresController {
	
	@GetMapping("manga/all")
    public MangaGenres[] getAllGenres() {
        return MangaGenres.values();
    }
	
	@GetMapping("manga/mature/all")
    public MangaMatureGenres[] getAllMatureGenres() {
        return MangaMatureGenres.values();
    }
	
	@GetMapping("book/all")
    public BookGenres[] getAllBookGenres() {
        return BookGenres.values();
    }
	
	@GetMapping("book/mature/all")
    public MatureBookGenres[] getAllMatureBookGenres() {
        return MatureBookGenres.values();
    }

}
