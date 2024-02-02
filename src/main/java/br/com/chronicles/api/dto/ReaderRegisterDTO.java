package br.com.chronicles.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ReaderRegisterDTO(String name, String lastName,@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate) {

}
