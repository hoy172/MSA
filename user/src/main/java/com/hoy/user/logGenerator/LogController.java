package com.hoy.user.logGenerator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LogController {

    private final LogGeneratorService logGeneratorService;

    @GetMapping("/start")
    public void logStart(){

        logGeneratorService.startScheduler();
    }

    @GetMapping("/stop")
    public void logStop(){
        logGeneratorService.stopScheduler();
    }
}
