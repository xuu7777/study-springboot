package com.xu.studyspringboot.mapper;

import com.xu.studyspringboot.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("admin", new User(1, "admin", "123456"));
        userMap.put("xiaoming", new User(2, "xiaoming", "123"));
        userMap.put("root", new User(3, "root", "root"));
    }

    public User loginin(String username, String pwd) {
        User user = userMap.get(username);
        if (user == null) {
            return null;
        }

        if (user.getPwd().equals(pwd)) {
            return user;
        }

        return null;

    }

    public List<User> listUser() {
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }

}
