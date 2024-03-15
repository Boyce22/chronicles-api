package br.com.chronicles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.model.response.DefaultResponse;

@RequestMapping("/file")
@RestController
public class FileController {

	private final FileServiceImpl fileService;

	public FileController(FileServiceImpl fileService) {
		this.fileService = fileService;
	}

	@PostMapping
	public ResponseEntity<DefaultResponse> upload(@RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(fileService.save(file));
	}

}
