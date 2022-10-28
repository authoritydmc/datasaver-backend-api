package com.authoritydmc.datasaver.controller;

import com.authoritydmc.datasaver.entity.FileEntity;
import com.authoritydmc.datasaver.services.FileService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/download")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class downloadController {

    private FileService fileService;

    @GetMapping()
@ResponseBody
    public String downloadDefault() {
        return "Pass UUID of file to download";
    }

    @GetMapping("{uuid}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String uuid) throws Exception {
        final Logger LOGGER=LoggerFactory.getLogger(downloadController.class);
        FileEntity file = fileService.getFileEntityBYUUID(uuid);
        LOGGER.debug("Trying to download file "+uuid);
        System.out.println("DOWNLOAD FILE METHOD CALLED"+file);
        if (file == null) {
            LOGGER.debug("File not found "+uuid);
            System.out.println("DOWNLOAD FILE METHOD CALLED file is null");

            return ResponseEntity.status(404)
                    .build();
        }
        LOGGER.debug("File found "+uuid);

        String[] fileType = file.getType().split("/");
        byte[] isr = file.getData();
        String fileName = file.getName();
        HttpHeaders respHeaders = new HttpHeaders();
//        respHeaders.setContentLength(isr.length);
        respHeaders.setContentType(new MediaType(fileType[0], fileType[1]));
        respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        return new ResponseEntity<byte[]>(isr, respHeaders, HttpStatus.OK);

    }
}
