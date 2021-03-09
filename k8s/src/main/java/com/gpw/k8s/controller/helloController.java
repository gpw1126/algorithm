package com.gpw.k8s.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Gpw
 * @Date:2021/3/8
 * @Description:
 */
@RestController
public class helloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
