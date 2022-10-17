package com.authoritydmc.datasaver.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${api_version}")
    private  String api_version;
    @GetMapping
    public String welcome()
    {

        return "Welcome to DataSaver Api ,Version : "+api_version;
    }
}
