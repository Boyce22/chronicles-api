package br.com.chronicles.controller;

import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    private final WorkServiceImpl workService;

    List<String> ALLOWED_CONTENT_TYPES = List.of("application/pdf");

    public WorkController(WorkServiceImpl workService) {
        this.workService = workService;
    }

    @PostMapping("/create")
    public ResponseEntity<WorkDetailsDTO> create(@RequestPart WorkCreateDTO dto,
                                                 @RequestPart("file") MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        if (!ALLOWED_CONTENT_TYPES.contains(contentType) || contentType == null) {
            ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File type not supported");
        }
        return ResponseEntity.ok(workService.create(dto, file));
    }

}