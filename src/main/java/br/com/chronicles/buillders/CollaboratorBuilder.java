package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Collaborator;

import java.time.LocalDate;

public interface CollaboratorBuilder {

    CollaboratorBuilder withName(String name);

    CollaboratorBuilder withLastName(String lastName);

    CollaboratorBuilder withReference(String reference);

    CollaboratorBuilder withCpf(String cpf);

    CollaboratorBuilder withEmail(String email);

    CollaboratorBuilder withBirthDate(LocalDate birthDate);

    CollaboratorBuilder disable();

    CollaboratorBuilder active();

    Collaborator build();
}
