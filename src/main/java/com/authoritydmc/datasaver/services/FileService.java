package com.authoritydmc.datasaver.services;


import com.authoritydmc.datasaver.DTO.File_DTO;
import com.authoritydmc.datasaver.DTO.Response_file;
import com.authoritydmc.datasaver.entity.FileEntity;
import com.authoritydmc.datasaver.repos.FileRepo;
import com.authoritydmc.datasaver.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor
public class FileService {

    private FileRepo fileRepo;
    public Response_file SaveFile(MultipartFile file,String sendUserID) throws IOException {
        FileEntity lcfile=new FileEntity();

        lcfile.setData(file.getBytes());
        lcfile.setName(file.getOriginalFilename());
        lcfile.setType(file.getContentType());
        lcfile.setDownloadURL(CommonUtils.getUUID());
        lcfile.setUserID(sendUserID);
        System.out.println("Savingg "+file);
        fileRepo.save(lcfile);
        return new Response_file(lcfile);
    }

    public Response_file SaveFile(File_DTO dto)
    {
        FileEntity file=new FileEntity();

        file.setData(CommonUtils.decodeBase64(dto.getData()));
        file.setName(dto.getName());
        file.setType(dto.getType());
        file.setDownloadURL(CommonUtils.getUUID());
        file.setUserID(dto.getUserID());
        System.out.println("Savingg "+file);
        fileRepo.save(file);
        return new Response_file(file);
    }

    public byte[] getFiletoDownload(String uuid)
    {

//        try
        try {
          FileEntity file= fileRepo.findByDownloadURL(uuid);
            return file.getData();
        }catch (Exception e)
        {
            return null;
        }
    }
    public Response_file getFile(String uuid)
    {

        return new Response_file(fileRepo.findByDownloadURL(uuid));
    }
    public FileEntity getFileEntityBYUUID(String uuid)
    {
        try {
            FileEntity file= fileRepo.findByDownloadURL(uuid);
            return file;
        }catch (Exception e)
        {
            return null;
        }
    }
    public Response_file[] getFilebyUserId(String userID) {

       FileEntity[] fileEntities= fileRepo.findAllByUserID(userID);

        Response_file [] response_files=new Response_file[fileEntities.length];
        int cnt=0;
        for (FileEntity file:fileEntities)
        {
            response_files[cnt++]=new Response_file(file);
        }

        return  response_files;
    }
}
