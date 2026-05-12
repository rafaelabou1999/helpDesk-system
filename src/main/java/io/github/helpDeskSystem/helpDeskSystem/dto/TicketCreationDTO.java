package io.github.helpDeskSystem.helpDeskSystem.dto;

import io.github.helpDeskSystem.helpDeskSystem.model.Status;
import io.github.helpDeskSystem.helpDeskSystem.model.User;

import java.time.LocalDateTime;

public record TicketCreationDTO(String title, String description, Status status) {
}
