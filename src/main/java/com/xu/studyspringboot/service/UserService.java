package com.xu.studyspringboot.service;

import com.xu.studyspringboot.pojo.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);

    List<User> listUser();

}
