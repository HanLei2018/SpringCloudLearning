package com.hxy.sericefeign.com.hxy.feign.service.impl;

import com.hxy.sericefeign.com.hxy.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Service;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-07 15:15
 **/
@Service
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
