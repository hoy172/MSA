package com.hoy.user.logGenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public void logGeneration(){

        log.info("로그 발생 로그발생 !!!! " + new Random().nextInt());
    }
}
