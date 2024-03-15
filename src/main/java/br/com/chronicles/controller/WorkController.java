package br.com.chronicles.controller;

import br.com.chronicles.interfaces.WorkServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<WorkDetailsDTO> create(@RequestBody WorkCreateDTO dto) {
		return ResponseEntity.ok(workService.create(dto));
	}

}
