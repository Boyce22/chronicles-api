package br.com.chronicles.api.dto;

import java.time.LocalDate;

public record ReaderRegisterDTO(String name, String lastName, LocalDate birthDate) {

}
