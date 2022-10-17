package com.authoritydmc.datasaver.resources;

import com.authoritydmc.datasaver.DTO.file_dto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
@CrossOrigin("http://localhost:4200")
public class fileController {

    @PostMapping("")
    public String upload_file(@RequestBody file_dto fileDTO)
    {


        return "File Upload Successful"+fileDTO;
    }

    @GetMapping("")
    public String get_users_all_file()
    {
        return "TODO::return user's all file ";
    }

    @GetMapping("/{id}")
    public String getfile(@PathVariable String id)
    {
        return "User's file download link"+id;
    }
}
