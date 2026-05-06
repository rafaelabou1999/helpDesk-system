package io.github.helpDeskSystem.helpDeskSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreationDTO(Long id, @NotBlank String name, @Email @NotBlank String email, String phoneNumber) {
}
