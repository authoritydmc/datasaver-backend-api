package com.authoritydmc.datasaver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FILES")
public class FileEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;
    @Lob
    private byte[] data;
    private Long userID;

    private  String downloadURL;

    private LocalDateTime upload_time;

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +

                ", userID=" + userID +
                ", downloadURL='" + downloadURL + '\'' +
                ", upload_time=" + upload_time +
                '}';
    }
}
