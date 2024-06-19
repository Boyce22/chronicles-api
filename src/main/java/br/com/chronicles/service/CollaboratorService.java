package br.com.chronicles.service;

import br.com.chronicles.interfaces.CollaboratorServiceImpl;
import br.com.chronicles.model.entity.Collaborator;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.CollaboratorRegisterDTO;
import br.com.chronicles.model.request.CollaboratorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;
import br.com.chronicles.model.response.DefaultResponse;
import br.com.chronicles.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorService implements CollaboratorServiceImpl {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorService(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public CollaboratorDetailsDTO register(CollaboratorRegisterDTO dto) {
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator.create().registrar(dto)));
    }

    @Override
    public CollaboratorDetailsDTO update(CollaboratorUpdateDTO dto, Long id) {
        return new CollaboratorDetailsDTO(collaboratorRepository.save(findById(id).update(dto)));
    }

    @Override
    public List<CollaboratorDetailsDTO> findAll() {
        return collaboratorRepository.findAllActive().stream().map(CollaboratorDetailsDTO::new).toList();
    }

    @Override
    public List<CollaboratorDetailsDTO> findByReference(String reference) {
        return collaboratorRepository.findByReference(reference).stream().map(CollaboratorDetailsDTO::new).toList();
    }

    @Override
    public DefaultResponse disable(Long id) {
        Collaborator collaborator = findById(id);
        if (collaborator.getIsActive()) {
            collaboratorRepository.save(collaborator.disable());
            return new DefaultResponse("User disabled successfully");
        }
        return new DefaultResponse("Error");
    }

    @Override
    public DefaultResponse active(Long id) {
        Collaborator collaborator = findById(id);
        if (!collaborator.getIsActive()) {
            collaboratorRepository.save(collaborator.active());
            return new DefaultResponse("User activated successfully");
        }
        return new DefaultResponse("Error");
    }

    @Override
    public CollaboratorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto) {
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator.create().grantAuthorAccessToReader(reader, dto)));
    }

    @Override
    public Collaborator findById(Long id) {
        return collaboratorRepository.findById(id).orElseThrow(() -> new RuntimeException("Collaborator não encontrado"));
    }

}
