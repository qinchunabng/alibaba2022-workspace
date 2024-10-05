package com.qin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fb")
    public String fallbackHandle(){
        return "This is the gateway fallback.";
    }
}
