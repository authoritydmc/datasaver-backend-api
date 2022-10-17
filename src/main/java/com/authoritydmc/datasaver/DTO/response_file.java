package com.authoritydmc.datasaver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class response_file {

    private String name;

    private String type;

    private long Size;
    private String downloadURL;

    @Override
    public String toString() {
        return "response_file{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", Size=" + Size +
                ", downloadURL='" + downloadURL + '\'' +
                '}';
    }
}
