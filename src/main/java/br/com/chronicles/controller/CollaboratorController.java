package br.com.chronicles.controller;

import br.com.chronicles.interfaces.CollaboratorService;
import br.com.chronicles.model.request.CollaboratorRegisterDTO;
import br.com.chronicles.model.request.CollaboratorUpdateDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CollaboratorDetailsDTO>> findAll() {
        List<CollaboratorDetailsDTO> collaborators = collaboratorService.findAll();
        return collaborators.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(collaborators);
    }

    @GetMapping("/reference/{reference}")
    public ResponseEntity<List<CollaboratorDetailsDTO>> findByReference(@PathVariable String reference) {
        return ResponseEntity.ok(collaboratorService.findByReference(reference));
    }

    @PostMapping("/register")
    public ResponseEntity<CollaboratorDetailsDTO> registerCollaborator(@RequestBody @Valid CollaboratorRegisterDTO dto) {
        return ResponseEntity.ok(collaboratorService.register(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CollaboratorDetailsDTO> updateCollaborator(@RequestBody CollaboratorUpdateDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(collaboratorService.update(dto, id));
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<CollaboratorDetailsDTO> activeCollaborator(@PathVariable Long id) {
        return ResponseEntity.ok(collaboratorService.active(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CollaboratorDetailsDTO> deleteCollaborator(@PathVariable Long id) {
        return ResponseEntity.ok(collaboratorService.disable(id));
    }

}
