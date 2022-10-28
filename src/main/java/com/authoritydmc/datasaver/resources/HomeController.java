package com.authoritydmc.datasaver.resources;

import com.authoritydmc.datasaver.DTO.ResponseMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class HomeController {

    @Value("${api_version}")
    private  String api_version;
    @GetMapping
    public ResponseEntity<ResponseMessage> welcome()
    {

       var rf=new ResponseMessage( "Welcome to DataSaver Api ,Version : "+api_version);

        return ResponseEntity.status(HttpStatus.OK).body(rf);
    }
}
