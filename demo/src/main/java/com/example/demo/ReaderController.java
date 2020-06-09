package com.example.demo;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ReaderController {

    @Scheduled(fixedDelay = 1000)
    @SendTo("/send")
    public String schduleTask(){
        return "abc";
    }


}
