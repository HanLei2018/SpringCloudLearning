package com.hxy.configclient.com.hxy.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-15 09:50
 **/
@RestController
public class TestController {

    @Value("${foo}")
    String foo;

    @GetMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
