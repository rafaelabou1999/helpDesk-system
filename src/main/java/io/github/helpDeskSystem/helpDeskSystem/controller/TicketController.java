package io.github.helpDeskSystem.helpDeskSystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class TicketController {
    @PostMapping("users/{id}/tickets")
    @Operation(summary = "Create a ticket")
    public void createTicket(@PathVariable Long id){

    }
}
