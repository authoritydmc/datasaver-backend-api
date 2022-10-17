package com.authoritydmc.datasaver.repos;

import com.authoritydmc.datasaver.entity.file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fileRepo extends JpaRepository<file,String> {
}
