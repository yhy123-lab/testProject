package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommunityApplication {

    @PostConstruct
    public void init(){
        //解决netty启动冲突
        // see Netty4Utils.setAvaliableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors","false");
    }
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }
}
