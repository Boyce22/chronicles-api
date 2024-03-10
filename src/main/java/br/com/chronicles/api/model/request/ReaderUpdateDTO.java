package br.com.chronicles.api.model.request;

import java.time.LocalDate;

public record ReaderUpdateDTO(String name, String lastName, String cpf, LocalDate birthDate) {

}
