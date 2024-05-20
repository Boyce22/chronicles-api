package br.com.chronicles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.chronicles.interfaces.ComentaryServiceImpl;
import br.com.chronicles.model.response.ComentaryDetailsDTO;

@RestController
@RequestMapping("/comentary")
public class ComentaryController {

	private ComentaryServiceImpl comentaryServiceImpl;

	public ComentaryController(ComentaryServiceImpl comentaryServiceImpl) {
		this.comentaryServiceImpl = comentaryServiceImpl;
	}

	@PostMapping("/commentWork")
	public ResponseEntity<ComentaryDetailsDTO> register(@RequestBody String content, @RequestParam Long workId,
			@RequestParam Long readerId) {
		return ResponseEntity.ok(comentaryServiceImpl.create(content, workId, readerId));
	}

}
