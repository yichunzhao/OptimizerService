/*
 * 
 * this is only for verifying the controller is working remotley
 * 
 */
package com.ynz.optimizer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

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

    @RequestMapping("/test")
    public @ResponseBody DeferredResult<String> handleTestRequest() {

        logger.info("handler started");
        final DeferredResult<String> deferredResult = new DeferredResult<>();

        new Thread(() -> {
            logger.info("async task started");
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("async task finished");
            deferredResult.setResult("test async result");
        }).start();

        logger.info("handler finished");
        deferredResult.setResult("accepted, and doing it");
        return deferredResult;
    }

}
