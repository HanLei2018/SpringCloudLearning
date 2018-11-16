package com.hxy.serviceribbon.com.hxy.ribbon.controller;

import com.hxy.serviceribbon.com.hxy.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-07 13:35
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
