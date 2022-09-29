package com.example.demo0926.controller;

import com.example.demo0926.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello,%s";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/greeting
    //http://localhost:8080/greeting?name1=xxx
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name1",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
