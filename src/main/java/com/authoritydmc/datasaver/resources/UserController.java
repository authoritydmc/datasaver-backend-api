package com.authoritydmc.datasaver.resources;

import com.authoritydmc.datasaver.DTO.ResponseMessage;
import com.authoritydmc.datasaver.DTO.UserDTO;
import com.authoritydmc.datasaver.DTO.UserLoginDTO;
import com.authoritydmc.datasaver.DTO.UserLoginResponse;
import com.authoritydmc.datasaver.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserLoginResponse> signupUser(@RequestBody UserDTO user)
    {


       UserLoginResponse responseMessage= userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

    @PostMapping ("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginDTO userLoginDTO)
    {
        UserLoginResponse userLoginResponse=userService.loginUser(userLoginDTO);
        return  ResponseEntity.status(HttpStatus.OK).body(userLoginResponse);
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseMessage> loginGet()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Please send POST METHOD email and password_hashed "));

    }
}
