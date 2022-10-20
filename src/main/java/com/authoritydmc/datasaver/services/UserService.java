package com.authoritydmc.datasaver.services;


import com.authoritydmc.datasaver.DTO.ResponseMessage;
import com.authoritydmc.datasaver.DTO.UserDTO;
import com.authoritydmc.datasaver.DTO.UserLoginDTO;
import com.authoritydmc.datasaver.DTO.UserLoginResponse;
import com.authoritydmc.datasaver.entity.UserEntity;
import com.authoritydmc.datasaver.repos.UserRepo;
import com.authoritydmc.datasaver.utils.UserUtils;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private UserRepo userRepo;

    public UserLoginResponse createUser(UserDTO userDTO)
    {
        UserEntity user=new UserEntity();
        UserLoginResponse userLoginResponse=  new UserLoginResponse();
        user.setUserName(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword_hashed(userDTO.getPassword());
        user.setDoj(LocalDateTime.now());
        user.setLastLoggedIn(LocalDateTime.now());
try {
    userRepo.save(user);
    userLoginResponse.setStatus(true);
    userLoginResponse.setToken(UserUtils.getToken());
    userLoginResponse.setEmail(user.getEmail());
    userLoginResponse.setUserID(user.getUserID());
    userLoginResponse.setLastLogin(user.getLastLoggedIn());
    userLoginResponse.setMessage("Successfully create User: "+user);

}catch (DataIntegrityViolationException e)
{
    userLoginResponse.setMessage("Failed to create User ,error Occurred: "+e.getLocalizedMessage());
}


        return  userLoginResponse;


    }

    public UserLoginResponse loginUser(UserLoginDTO userLoginDTO)
    {

      UserLoginResponse userLoginResponse=  new UserLoginResponse();
      UserEntity user=  userRepo.findByEmail(userLoginDTO.getEmail());

        if (user!=null)
        {
//            compare password

            if (user.getPassword_hashed().equals(userLoginDTO.getPassword()))
            {
//                valid login send token;
                userLoginResponse.setStatus(true);
                userLoginResponse.setToken(UserUtils.getToken());
                userLoginResponse.setEmail(user.getEmail());
                userLoginResponse.setUserID(user.getUserID());
                userLoginResponse.setMessage("SuccessFully logged In "+user);
                userLoginResponse.setLastLogin(user.getLastLoggedIn());

//                after succesfully login update login Time

                user.setLastLoggedIn(LocalDateTime.now());
                userRepo.save(user);
            }
        }

        return userLoginResponse;
    }
}
