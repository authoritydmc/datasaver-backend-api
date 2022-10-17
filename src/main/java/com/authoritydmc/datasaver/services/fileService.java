package com.authoritydmc.datasaver.services;


import com.authoritydmc.datasaver.DTO.file_dto;
import com.authoritydmc.datasaver.DTO.response_file;
import org.springframework.stereotype.Service;

@Service
public class fileService {

    public response_file SaveFile(file_dto dto)
    {
        return new response_file();
    }

    public response_file getFile(String id)
    {
        return  new response_file();
    }
}
