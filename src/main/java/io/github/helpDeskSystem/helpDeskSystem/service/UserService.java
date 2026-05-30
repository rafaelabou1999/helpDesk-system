package io.github.helpDeskSystem.helpDeskSystem.service;

import io.github.helpDeskSystem.helpDeskSystem.dto.UserCreationDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.UserDTO;
import io.github.helpDeskSystem.helpDeskSystem.model.User;
import io.github.helpDeskSystem.helpDeskSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;


    public List<UserDTO> displayAllUsers() {
        return repository.findAll().stream().map(u -> new UserDTO(u.getId(), u.getName(), u.getEmail(), u.getPhoneNumber(), u.getTicketList())).toList();
    }

    public UserDTO createUser(UserCreationDTO dto) {
        var user = new User(dto);
        repository.save(user);

        return new UserDTO(user);
    }

    public UserDTO displayOneUser(Long id) {
        var user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user);
    }
}
