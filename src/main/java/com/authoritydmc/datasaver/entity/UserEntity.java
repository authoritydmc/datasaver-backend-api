package com.authoritydmc.datasaver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    Long UserID;
    String userName;
    String name;
    String email;
    String password_hashed;
    LocalDateTime doj;
    LocalDateTime lastLoggedIn;


}
