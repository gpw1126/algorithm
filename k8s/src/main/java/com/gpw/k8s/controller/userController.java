package com.gpw.k8s.controller;

import com.gpw.k8s.bean.User;
import com.gpw.k8s.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Gpw
 * @Date:2021/3/8
 * @Description:
 */
@Controller
public class userController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/get/{name}")
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        return this.userMapper.findUserByName(name);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String insertUser(User user) {
        this.userMapper.insertUser(user);
        return "save success!";
    }
}
