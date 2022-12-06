package com.authoritydmc.datasaver.resources;

import com.authoritydmc.datasaver.DTO.ResponseMessage;
import com.authoritydmc.datasaver.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {
    @Value("${server.port}")
    private int port;
    @Value("${api_version}")
    private  String api_version;
    @GetMapping
    public ResponseEntity<Object> welcome() throws UnknownHostException {
        HashMap<String,String> map=new HashMap<>();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String BASEurl="http://"+ip+":"+port+"/";
        map.put("message"," Welcome to DataSaver Api ,Version : "+api_version +"<br>Available @ <a href='"+BASEurl+"' target='_blank'>"+BASEurl+"</a>");

        CommonUtils.FULL_DOWNLOAD_URL_WITH_IP=BASEurl+CommonUtils.BASE_DOWNLOAD_URL;
        map.put("BASE_IP",ip);
        map.put("BASE_PORT",String.valueOf(port));
        map.put("BASE_URL",BASEurl);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
