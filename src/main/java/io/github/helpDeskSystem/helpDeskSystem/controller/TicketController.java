package io.github.helpDeskSystem.helpDeskSystem.controller;

import io.github.helpDeskSystem.helpDeskSystem.dto.TicketCreationDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.TicketDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.TicketStatusDTO;
import io.github.helpDeskSystem.helpDeskSystem.model.Ticket;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import io.github.helpDeskSystem.helpDeskSystem.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class TicketController {
    @Autowired
    TicketService service;


    @PostMapping("/{id}/tickets")
    @Operation(summary = "Create a ticket")
    public ResponseEntity<TicketDTO> createTicket(@PathVariable Long id, @RequestBody @Valid TicketCreationDTO dto, UriComponentsBuilder uriBuilder){
       var ticketDto = service.createTicket(id, dto);

       var uri = uriBuilder.path("/users/{id}/tickets").buildAndExpand(id).toUri();
       return ResponseEntity.created(uri).body(ticketDto);
    }

    @PatchMapping("/{userId}/tickets/{ticketId}")
    public ResponseEntity<TicketDTO> callAttendant(@RequestBody TicketStatusDTO dto, @PathVariable Long userId, @PathVariable Long ticketId, UriComponentsBuilder uriBuilder){
        var ticketDto = service.callAttendant(userId, ticketId);

        var uri = uriBuilder.path("/users/{userId}/tickets/{ticketId}").buildAndExpand(userId, ticketId).toUri();
        return ResponseEntity.created(uri).body(ticketDto);
    }

}
