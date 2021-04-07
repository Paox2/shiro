package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }

    public String addUser(User user) {
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, 10000).toBase64();
        user.setPassword(s);
        user.setSalt(salt);
        int i = userMapper.addUser(user);
        return i == 1 ? "success" : "fail";
    }
}
