package com.hoy.reader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReaderController {

    @GetMapping("/")
    public String getReader(){
        return "reader information";
    }
}
