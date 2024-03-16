package br.com.chronicles.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;

@RestController
@RequestMapping("/work")
public class WorkController {

	private final WorkServiceImpl workService;

	public WorkController(WorkServiceImpl workService) {
		this.workService = workService;
	}

	@PostMapping("/create")
	public ResponseEntity<WorkDetailsDTO> create(@RequestPart WorkCreateDTO dto,
			@RequestPart("file") MultipartFile file) throws IOException {
		return ResponseEntity.ok(workService.create(dto, file));
	}

}