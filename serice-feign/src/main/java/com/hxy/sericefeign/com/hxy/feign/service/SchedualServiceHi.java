package com.hxy.sericefeign.com.hxy.feign.service;

import com.hxy.sericefeign.com.hxy.feign.service.impl.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-07 13:58
 **/
@FeignClient(value = "service-user",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @GetMapping("/user/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
