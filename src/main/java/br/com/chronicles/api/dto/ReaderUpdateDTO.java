package br.com.chronicles.api.dto;

import java.time.LocalDate;

public record ReaderUpdateDTO(String name, String lastName, String cpf, LocalDate birthDate) {

}
