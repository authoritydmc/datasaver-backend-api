package com.authoritydmc.datasaver.services;


import com.authoritydmc.datasaver.DTO.ResponseMessage;
import com.authoritydmc.datasaver.DTO.UserDTO;
import com.authoritydmc.datasaver.DTO.UserLoginDTO;
import com.authoritydmc.datasaver.DTO.UserLoginResponse;
import com.authoritydmc.datasaver.entity.UserEntity;
import com.authoritydmc.datasaver.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public ResponseMessage createUser(UserDTO userDTO)
    {
        UserEntity user=new UserEntity();
        String msg="Successfully created the User .."+user;

        userRepo.save(user);
        return new ResponseMessage(msg);
    }

    public UserLoginResponse loginUser(UserLoginDTO userLoginDTO)
    {


        return new UserLoginResponse();
    }
}
