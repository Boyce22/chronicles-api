package br.com.chronicles.model.request;

import java.time.LocalDate;

public record ReaderUpdateDTO(String name, String lastName, String email, LocalDate birthDate) {

}
