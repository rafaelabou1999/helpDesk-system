package io.github.helpDeskSystem.helpDeskSystem.dto;

import io.github.helpDeskSystem.helpDeskSystem.model.Status;
import io.github.helpDeskSystem.helpDeskSystem.model.User;

import java.time.LocalDateTime;

public class TicketDTO {
    public TicketDTO(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Status status, User user) {
    }
}
