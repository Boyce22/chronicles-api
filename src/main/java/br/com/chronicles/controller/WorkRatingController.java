package br.com.chronicles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.interfaces.WorkRatingService;
import br.com.chronicles.model.entity.WorkReaderRating;
import br.com.chronicles.model.request.WorkRatingDTO;
import br.com.chronicles.model.response.WorkRatingDetailsDTO;

@RestController
@RequestMapping("/work-rating")
public class WorkRatingController {

	private final WorkRatingService ratingService;

	public WorkRatingController(WorkRatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping("/rate")
	public ResponseEntity<WorkRatingDetailsDTO> rating(@RequestBody WorkRatingDTO dto) {
		return ResponseEntity.ok(ratingService.verifyIfExistsAndRateWork(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkReaderRating> findById(@PathVariable Long id) {
		return ResponseEntity.ok(ratingService.findById(id));
	}
}
