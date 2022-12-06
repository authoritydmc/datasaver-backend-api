package com.authoritydmc.datasaver.DTO;


import com.authoritydmc.datasaver.entity.FileEntity;
import com.authoritydmc.datasaver.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Response_file {

    private String name;

    private String type;

    private long Size;
    private String fileURI;
    private String fullDownloadURL;
    private LocalDateTime upload_time;
    public Response_file(FileEntity file)
    {
        this.name=file.getName();
        this.type=file.getType();
        this.Size=file.getData().length;
        this.fileURI= file.getDownloadURL();
        this.upload_time=file.getUpload_time();
        this.fullDownloadURL=CommonUtils.FULL_DOWNLOAD_URL_WITH_IP+file.getDownloadURL();

    }

    @Override
    public String toString() {
        return "Response_file{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", Size=" + Size +
                ", fileURI='" + fileURI + '\'' +
                ", fullDownloadURL='" + fullDownloadURL + '\'' +
                '}';
    }
}
