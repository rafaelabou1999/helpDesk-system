package io.github.helpDeskSystem.helpDeskSystem.service;

import io.github.helpDeskSystem.helpDeskSystem.dto.TicketCreationDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.TicketDTO;
import io.github.helpDeskSystem.helpDeskSystem.model.Status;
import io.github.helpDeskSystem.helpDeskSystem.model.Ticket;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import io.github.helpDeskSystem.helpDeskSystem.repository.TicketRepository;
import io.github.helpDeskSystem.helpDeskSystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TicketService {
    @Autowired
    TicketRepository repository;

    @Autowired
    UserRepository repoUser;

    public TicketDTO createTicket(Long id, @Valid TicketCreationDTO dto) {
        User user = repoUser.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        var ticket = new Ticket(null, dto.title(), dto.description(), null, null, null, user);

        ticket.setStatus(Status.OPEN);
        repository.save(ticket);

        return new TicketDTO(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getCreatedAt(), null, ticket.getStatus(), ticket.getUser());
    }

    public TicketDTO callAttendant(Long userId, Long ticketId) {
        var user = repoUser.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        var ticket = repository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus(Status.IN_PROGRESS);
        repository.save(ticket);

        return new TicketDTO(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getCreatedAt(), null, ticket.getStatus(), ticket.getUser());
    }
}
