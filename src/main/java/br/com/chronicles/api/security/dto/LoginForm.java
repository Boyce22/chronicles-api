package br.com.chronicles.api.security.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(@NotBlank String email, @NotBlank String password) {

}
