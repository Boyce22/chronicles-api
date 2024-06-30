package br.com.chronicles.controller;

import br.com.chronicles.interfaces.CommentaryService;
import br.com.chronicles.model.response.CommentaryDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentary")
public class CommentaryController {

    private final CommentaryService commentaryService;

    public CommentaryController(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }

    @PostMapping("/commentWork")
    public ResponseEntity<CommentaryDetailsDTO> register(@RequestBody String content, @RequestParam Long workId,
                                                         @RequestParam Long readerId) {
        return ResponseEntity.ok(commentaryService.create(content, workId, readerId));
    }

}
