package br.com.chronicles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.enuns.BookGenres;
import br.com.chronicles.enuns.BookMatureGenres;
import br.com.chronicles.enuns.MangaGenres;
import br.com.chronicles.enuns.MangaMatureGenres;
import br.com.chronicles.interfaces.BookServiceImpl;
import br.com.chronicles.interfaces.MangaServiceImpl;

@RestController
@RequestMapping("/genres")
public class GenresController {

	private final MangaServiceImpl mangaService;

	private final BookServiceImpl bookService;

	public GenresController(MangaServiceImpl mangaService, BookServiceImpl bookService) {
		this.mangaService = mangaService;
		this.bookService = bookService;
	}

	@GetMapping("manga/all")
	public MangaGenres[] getAllGenres() {
		return mangaService.getGenres();
	}

	@GetMapping("manga/mature/all")
	public MangaMatureGenres[] getAllMatureGenres() {
		return mangaService.getMatureGenres();
	}

	@GetMapping("book/all")
	public BookGenres[] getAllBookGenres() {
		return bookService.getGenres();
	}

	@GetMapping("book/mature/all")
	public BookMatureGenres[] getAllMatureBookGenres() {
		return bookService.getMatureGenres();
	}

}
