package com.hoy.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@EnableAuthorizationServer
@RestController
public class Oauth2serverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2serverApplication.class, args);
    }

}
