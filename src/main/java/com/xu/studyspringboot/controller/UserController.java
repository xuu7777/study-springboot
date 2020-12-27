package com.xu.studyspringboot.controller;

import com.xu.studyspringboot.pojo.User;
import com.xu.studyspringboot.service.UserService;
import com.xu.studyspringboot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;

//    /**
//     * form 表单形式
//     * @param username
//     * @param pwd
//     * @return
//     */
//    @PostMapping("login")
//    public JsonData login(String username, String pwd) {
//        System.out.println("username = " + username + " pwd = " + pwd);
//        return JsonData.buildSuccess("");
//    }

    /**
     * json 形式
     *
     * @param user
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        System.out.println("user ==> " + user.toString());
        String token = userService.login(user.getUsername(), user.getPwd());
        if (token != null) {
            return JsonData.buildSuccess(token, "success");
        } else {
            return JsonData.buildError("用户名或密码错误");
        }

    }

    /**
     * 列出全部用户
     *
     * @return
     */
    @GetMapping("list_user")
    public JsonData listUser() {
        List<User> list = userService.listUser();
        return JsonData.buildSuccess(list, "success");
    }


}
