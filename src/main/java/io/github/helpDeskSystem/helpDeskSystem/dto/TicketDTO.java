package io.github.helpDeskSystem.helpDeskSystem.dto;

import io.github.helpDeskSystem.helpDeskSystem.model.Status;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TicketDTO {
    public TicketDTO(@NotNull Long id, @NotBlank String title, String description, @NotNull LocalDateTime createdAt, LocalDateTime updatedAt, @NotNull Status status, @NotNull User user) {
    }
}
