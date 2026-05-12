package io.github.helpDeskSystem.helpDeskSystem.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.helpDeskSystem.helpDeskSystem.dto.TicketCreationDTO;
import io.github.helpDeskSystem.helpDeskSystem.dto.UserCreationDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Ticket> ticketList;

    public User(UserCreationDTO dto){
        this.id = dto.id();
        this.name = dto.name();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
    }

}
