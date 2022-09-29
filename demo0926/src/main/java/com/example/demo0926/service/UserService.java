package com.example.demo0926.service;

import com.example.demo0926.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    // 取得所有 user
    @Cacheable(value = "getAllUsers", keyGenerator = "wiselyKeyGenerator")
    public List<User> getAllUsers() {
        System.out.println("----- getAllUsers start --------");
        List<User> users = findAllUser();
        System.out.println("----- getAllUsers end --------");
        return users;
    }

    // 取得 user by id
    @Cacheable(value = "user", key = "#p0")
    public User getUserById(String id) {
        System.out.println("----- getUserById start --------");
        User user = findUserById(id);
        System.out.println("----- getUserById start --------");
        return user;
    }

    // 清除 getAllUsers cache
    @CacheEvict(value = "getAllUsers", allEntries = true)
    public void clearGetAllUsersCache() {

    }

    // 清除 cache by id
    @CacheEvict(value = "user", key = "#p0")
    public void clearGetUserById(String id) {

    }
    private List<User> findAllUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("00001", "Tracy"));
        users.add(new User("00002", "Peggy"));
        users.add(new User("00003", "Kazzy"));
        users.add(new User("00001", "Bill"));
        return users;
    }

    private User findUserById(String id) {
        List<User> users = findAllUser();
        User user = users.stream().filter(u -> id.equals(u.getId())).findFirst().get();
        return user;
    }

    // 指定使用的 cacheManager 為 alternateCacheManager
    @Cacheable(value = "caffeineCache", cacheManager = "alternateCacheManager")
    public List<User> getAllUsersForCaffeine() {
        System.out.println("----- getAllUsersForCaffeine start --------");
        List<User> users = findAllUser();
        System.out.println("----- getAllUsersForCaffeine end --------");
        return users;
    }
}
