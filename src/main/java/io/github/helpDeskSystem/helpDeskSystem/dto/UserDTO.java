package io.github.helpDeskSystem.helpDeskSystem.dto;

import io.github.helpDeskSystem.helpDeskSystem.model.Ticket;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserDTO(Long id, @NotBlank String name, @Email @NotBlank String email, String phoneNumber, List<Ticket> ticketList){
    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getTicketList());
    }
}
