package com.hxy.eurekauser.com.hxy.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-07 11:13
 **/
@RestController
@RequestMapping("/user")
public class TestController {

    @Value("${server.port}")
    public String port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name",defaultValue = "hanl") String name) {
        return "hi:" + name + ", I am from port:" + port;
    }
}
