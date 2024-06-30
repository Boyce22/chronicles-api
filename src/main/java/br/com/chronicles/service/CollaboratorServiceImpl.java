package br.com.chronicles.service;

import br.com.chronicles.interfaces.CollaboratorService;
import br.com.chronicles.model.entity.Collaborator;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.request.CollaboratorRegisterDTO;
import br.com.chronicles.model.request.CollaboratorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import br.com.chronicles.model.response.CollaboratorDetailsDTO;
import br.com.chronicles.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public CollaboratorDetailsDTO register(CollaboratorRegisterDTO dto) {
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator
                .builder()
                .withName(dto.name())
                .withLastName(dto.lastName())
                .withCpf(dto.cpf())
                .withBirthDate(dto.birthDate())
                .build())
        );
    }

    @Override
    public CollaboratorDetailsDTO update(CollaboratorUpdateDTO dto, Long id) {
        Collaborator collaborator = findById(id);

        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator
                .update(collaborator)
                .withName(dto.name())
                .withLastName(dto.lastName())
                .withCpf(dto.cpf())
                .withBirthDate(dto.birthDate())
                .build())
        );
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
    public CollaboratorDetailsDTO disable(Long id) {
        Collaborator collaborator = findById(id);
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator.update(collaborator).disable().build()));
    }

    @Override
    public CollaboratorDetailsDTO active(Long id) {
        Collaborator collaborator = findById(id);
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator.update(collaborator).active().build()));
    }

    @Override
    public CollaboratorDetailsDTO grantAuthorAccess(Reader reader, ReaderChangeRequestDTO dto) {
        return new CollaboratorDetailsDTO(collaboratorRepository.save(Collaborator.builder()
                .withName(reader.getName())
                .withLastName(reader.getLastName())
                .withBirthDate(reader.getBirthDate())
                .withCpf(dto.cpf())
                .withReference(dto.reference())
                .build())
        );
    }

    @Override
    public Collaborator findById(Long id) {
        return collaboratorRepository.findById(id).orElseThrow(() -> new RuntimeException("Collaborator não encontrado"));
    }

}
