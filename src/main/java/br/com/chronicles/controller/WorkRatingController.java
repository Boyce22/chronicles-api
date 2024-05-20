package br.com.chronicles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.interfaces.WorkRatingServiceImpl;
import br.com.chronicles.model.entity.WorkReaderRating;
import br.com.chronicles.model.request.WorkRatingDTO;
import br.com.chronicles.model.response.WorkRatingDetailsDTO;

@RestController
@RequestMapping("/work-rating")
public class WorkRatingController {

	private final WorkRatingServiceImpl ratingService;

	public WorkRatingController(WorkRatingServiceImpl ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping
	public ResponseEntity<WorkRatingDetailsDTO> rating(@RequestBody WorkRatingDTO dto) {
		return ResponseEntity.ok(ratingService.verifyIfExists(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkReaderRating> findById(@PathVariable Long id) {
		return ResponseEntity.ok(ratingService.findById(id));
	}
}