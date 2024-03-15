package br.com.chronicles.model.response;

import jakarta.validation.constraints.NotBlank;

public record DefaultResponse(@NotBlank(message = "A mensagem do response não pode estar vazia") String response) {

}
