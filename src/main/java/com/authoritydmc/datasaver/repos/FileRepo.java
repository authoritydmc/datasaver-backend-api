package com.authoritydmc.datasaver.repos;

import com.authoritydmc.datasaver.DTO.Response_file;
import com.authoritydmc.datasaver.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileEntity, Long> {

    public FileEntity findByDownloadURL(String downloadURL);


    FileEntity[] findAllByUserID(String userID);
}
