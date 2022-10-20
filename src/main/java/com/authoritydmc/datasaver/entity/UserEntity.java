package com.authoritydmc.datasaver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
     Long userID;
    String userName;
    String name;
    @Column(unique = true)
    String email;
    String password_hashed;
    LocalDateTime doj;

    @Override
    public String toString() {
        return "UserEntity{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", doj=" + doj +
                ", lastLoggedIn=" + lastLoggedIn +
                '}';
    }

    LocalDateTime lastLoggedIn;

}
