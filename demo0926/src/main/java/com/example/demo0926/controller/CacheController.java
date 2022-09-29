package com.example.demo0926.controller;

import com.example.demo0926.controller.dto.response.StatusResource;
import com.example.demo0926.model.User;
import com.example.demo0926.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CacheController {
    @Autowired
    private UserService service;

    // 取得所有 user
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // 清除 getAllUsers cache
    @DeleteMapping("/all")
    public StatusResource clearGetAllUsersCache() {
        service.clearGetAllUsersCache();
        return new StatusResource("OK");
    }

    // 取得 user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    // 清除 cache by id
    @DeleteMapping("/{id}")
    public StatusResource clearGetUserById(@PathVariable String id) {
        service.clearGetUserById(id);
        return new StatusResource("OK");
    }

    @GetMapping("/getAllUsersForCaffeine")
    public List<User> getAllUsersForCaffeine() {
        return service.getAllUsersForCaffeine();
    }

}
