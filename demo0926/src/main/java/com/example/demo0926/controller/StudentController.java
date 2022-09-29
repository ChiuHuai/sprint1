package com.example.demo0926.controller;

import com.example.demo0926.controller.dto.request.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@Validated
public class StudentController {

    // 直接拋出 Exception
    @GetMapping("/test1")
    public void test1() throws Exception {
        throw new Exception("Test1 error");
    }

    // 透過 Student 類別做基礎檢核，模擬當不符合基礎檢核時拋 Exception
    @PostMapping("/test2")
    public void test2(@Valid @RequestBody Student s) {
        System.out.println(s.getName());
        System.out.println(s.getAge());
    }

    // 對 Query String 做基礎檢核，模擬當不符合基礎檢核時拋 Exception
    @GetMapping("/test3")
    public void test3(@NotEmpty(message = "message 不可為空值") String message,
                      @NotEmpty(message = "name 不可為空值") String name) {
        System.out.println(message);
    }
}
