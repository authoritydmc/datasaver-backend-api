package com.authoritydmc.datasaver.DTO;


import com.authoritydmc.datasaver.entity.FileEntity;
import com.authoritydmc.datasaver.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Response_file {

    private String name;

    private String type;

    private long Size;
    private String downloadURL;

    public Response_file(FileEntity file)
    {
        this.name=file.getName();
        this.type=file.getType();
        this.Size=file.getData().length;
        this.downloadURL= CommonUtils.BASE_DOWNLOAD_URL +file.getDownloadURL();

    }
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
