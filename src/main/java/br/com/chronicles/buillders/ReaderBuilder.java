package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Reader;

import java.time.LocalDate;

public interface ReaderBuilder {

    ReaderBuilder withName(String name);

    ReaderBuilder withLastName(String lastName);

    ReaderBuilder withEmail(String email);

    ReaderBuilder withBirthDate(LocalDate birthDate);

    ReaderBuilder disable();

    ReaderBuilder active();

    Reader build();
}
