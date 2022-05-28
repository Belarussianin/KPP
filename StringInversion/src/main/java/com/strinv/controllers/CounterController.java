package com.strinv.controllers;

import com.strinv.logger.appLogger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CounterController {

    static AtomicInteger service_calls = new AtomicInteger(0);

    synchronized public void incrementCalls(){
        service_calls.incrementAndGet();
        appLogger.setLog(Level.INFO, "Counter increment");
    }

    @GetMapping("/calls")
    synchronized public int displayCalls(){
        appLogger.setLog(Level.INFO, "Successful calls mapping");
        return service_calls.get();
    }
}
