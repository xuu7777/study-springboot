package com.xu.studyspringboot.service.impl;

import com.xu.studyspringboot.mapper.UserMapper;
import com.xu.studyspringboot.pojo.User;
import com.xu.studyspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    public static Map<String, User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {
        User user = userMapper.loginin(username, pwd);

        if (user == null) {
            return null;
        } else {
            String token = UUID.randomUUID().toString();
            System.out.println("username ==> " + username + "\n" + "token ==> " + token);
            sessionMap.put(token, user);
            return token;
        }

    }

    @Override
    public List<User> listUser() {
        List<User> list = userMapper.listUser();
        return list;
    }
}
