package br.com.chronicles.controller;

import br.com.chronicles.interfaces.ComentaryService;
import br.com.chronicles.model.response.ComentaryDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentary")
public class ComentaryController {

    private final ComentaryService comentaryService;

    public ComentaryController(ComentaryService comentaryService) {
        this.comentaryService = comentaryService;
    }

    @PostMapping("/commentWork")
    public ResponseEntity<ComentaryDetailsDTO> register(@RequestBody String content, @RequestParam Long workId,
                                                        @RequestParam Long readerId) {
        return ResponseEntity.ok(comentaryService.create(content, workId, readerId));
    }

}
