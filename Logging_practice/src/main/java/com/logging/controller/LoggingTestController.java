package com.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTestController {

    Logger log = LoggerFactory.getLogger(LoggingTestController.class);

    @GetMapping("/message")
    public String displayMessage()
    {
        log.debug("Hello displayed");

        return "Hello";
    }
}
