/*
 * 
 * this is only for verifying if the server is working
 * 
 */
package com.ynz.optimizer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YNZ
 */
@RestController()
public class HelloOptimizer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String getHello() {
        return "hello Im Optimizer!";
    }
}
