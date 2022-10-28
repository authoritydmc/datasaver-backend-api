package com.authoritydmc.datasaver.resources;

import com.authoritydmc.datasaver.DTO.Response_file;
import com.authoritydmc.datasaver.DTO.File_DTO;
import com.authoritydmc.datasaver.services.FileService;
import com.authoritydmc.datasaver.DTO.ResponseMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class FileController {

    private FileService fileService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("upload")
    public ResponseEntity<Object> upload_file(@RequestParam("userID") Optional<Long> userID,@RequestParam("file") MultipartFile file)
    {

        String message = "";
        try {
            Response_file rf=fileService.SaveFile(file,userID.orElse(-1l));

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(rf);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename()+ "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @PostMapping("")
    public ResponseEntity<Object> save_file(@RequestBody File_DTO dto)
    {

        String message = "File Doesn't exist";
        try {
            Response_file file=fileService.SaveFile(dto);
            String uuid="";

            return ResponseEntity.status(HttpStatus.OK).body(file);
        } catch (Exception e) {
            message = "Failed to upload the file : "+dto + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @GetMapping("")
    public ResponseEntity<Response_file[]> get_users_all_file(@RequestParam Optional<Long> userID)
    {

        String message = "File Doesn't exist";
        try {
            Response_file[] file= fileService.getFilebyUserId(userID.get());
            return ResponseEntity.status(HttpStatus.OK).body(file);
        } catch (Exception e) {
            message = "No files found for : " + userID+ "!";

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body( new Response_file[]{new Response_file()});

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response_file> getfile(@PathVariable String id)
    {

        String message = "File Doesn't exist";
        try {
           Response_file file= fileService.getFile(id);
            return ResponseEntity.status(HttpStatus.OK).body(file);
        } catch (Exception e) {
            message = "Could not find the file with id: " + id+ "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response_file());
        }
    }



}
