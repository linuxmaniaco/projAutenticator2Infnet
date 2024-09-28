package com.example.projAutenticator2Infnet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/PING")
public class PingController {

    @GetMapping
    public String ping(){
        return "PONG";
    }


}
