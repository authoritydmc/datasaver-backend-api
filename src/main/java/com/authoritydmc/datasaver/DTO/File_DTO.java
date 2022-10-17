package com.authoritydmc.datasaver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File_DTO {

        private String name;

        private String type;

        //Data needed to be in BASE64 String ....
        private String data;

        private String userID;



    @Override
    public String toString() {
        return "file_dto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +

                ", userID='" + userID + '\'' +
                '}';
    }
}


