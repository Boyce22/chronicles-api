package br.com.chronicles.controller;

import br.com.chronicles.interfaces.WorkService;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.model.response.WorkNonWithChapters;
import br.com.chronicles.model.response.WorkRegisterDetails;
import org.apache.tomcat.util.http.fileupload.impl.InvalidContentTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    private final WorkService workService;

    List<String> ALLOWED_CONTENT_TYPES = List.of("application/pdf");

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/create")
    public ResponseEntity<WorkRegisterDetails> create(@RequestPart WorkCreateDTO dto,
                                                      @RequestPart("file") MultipartFile file, @RequestPart("cover") MultipartFile cover) throws IOException {
        if (!ALLOWED_CONTENT_TYPES.contains(file.getContentType())) {
            throw new InvalidContentTypeException("Envie um PDF");
        }
        return ResponseEntity.ok(workService.create(dto, file, cover));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<WorkNonWithChapters>> findAll() {
        List<WorkNonWithChapters> works = workService.findAll();
        return works.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(works);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(workService.findWorkDetailsById(id));
    }

}