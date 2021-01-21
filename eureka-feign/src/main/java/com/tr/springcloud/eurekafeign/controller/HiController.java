package com.tr.springcloud.eurekafeign.controller;

import com.tr.springcloud.eurekafeign.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TR
 * @date 2021/1/19 下午5:19
 */
@RestController
public class HiController {

    @Resource
    HiService hiService;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        return hiService.hi(name);
    }

}
