package com.authoritydmc.datasaver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {

    boolean status=false;
    String message="Failed to Login!!";
    String token="-1";
   long userID=-1l;
   String email="NA";
   LocalDateTime lastLogin;
}
