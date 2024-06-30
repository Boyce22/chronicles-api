package br.com.chronicles.model.response;

import br.com.chronicles.model.entity.Collaborator;

import java.time.LocalDate;

public record CollaboratorDetailsDTO(Long id, String name, String lastName, String reference, String cpf,
                                     LocalDate birthDate) {

    public CollaboratorDetailsDTO(Collaborator collaborator) {
        this(collaborator.getId(), collaborator.getName(), collaborator.getLastName(), collaborator.getReference(), collaborator.getCpf(),
                collaborator.getBirthDate());
    }
}
