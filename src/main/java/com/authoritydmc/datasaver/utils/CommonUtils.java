package com.authoritydmc.datasaver.utils;

import java.util.Base64;
import java.util.UUID;

public class CommonUtils {

    public static final String BASE_DOWNLOAD_URL = "/download/";
    public static  final String FULL_DOWNLOAD_URL="http://localhost:8080/download/";

    public static byte[] decodeBase64(String encoded_str)
    {

     return Base64.getDecoder().decode(encoded_str);
    }

    public static String getUUID()
    {
    return   UUID.randomUUID().toString();

    }

    public static byte [] sampleFile()
    {
        return new byte[] {1,1,1};
    }

}
