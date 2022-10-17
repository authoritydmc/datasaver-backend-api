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
public class file_dto {

        private String name;

        private String type;

        private byte[] data;

        private String userID;

    @Override
    public String toString() {
        return "file_dto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                ", userID='" + userID + '\'' +
                '}';
    }
}


