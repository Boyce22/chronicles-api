package br.com.chronicles.model.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;

public record CollaboratorUpdateDTO(@NotBlank String name, @NotBlank String lastName, @NotBlank String cpf,
		@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate birthDate) {

}
