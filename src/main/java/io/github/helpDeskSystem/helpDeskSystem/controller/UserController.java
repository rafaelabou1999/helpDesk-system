package io.github.helpDeskSystem.helpDeskSystem.controller;

import io.github.helpDeskSystem.helpDeskSystem.dto.UserCreationDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.UserDTO;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import io.github.helpDeskSystem.helpDeskSystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    @Operation(summary = "Display all users")
    public ResponseEntity<List<UserDTO>> displayAllUsers(){
        List<UserDTO> dataUsers = service.displayAllUsers();
        return ResponseEntity.ok(dataUsers);
    }

    @PostMapping
    @Operation(summary = "Create an user")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserCreationDTO dto, UriComponentsBuilder uriBuilder){
        return service.createUser(dto, uriBuilder);
    }
}
