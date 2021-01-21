package com.tr.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @date 2021/1/19 下午3:10
 */
@RestController
public class HiController {

    @Value("${spring.application.name}")
    private String server;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        return "Hi " + name + ", response from " + server + ", port: " + port;
    }

}
