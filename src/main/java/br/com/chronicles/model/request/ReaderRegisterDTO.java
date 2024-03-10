package br.com.chronicles.model.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ReaderRegisterDTO(String name, String lastName, String email, String password, @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate) {

}
