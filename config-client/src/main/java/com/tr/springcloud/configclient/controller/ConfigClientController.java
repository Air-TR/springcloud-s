package com.tr.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @date 2021/1/21 上午11:24
 */
@RestController
public class ConfigClientController {

    @Value("${version}")
    private String version;

    @Value("${name}")
    private String name;

    @GetMapping("/version")
    public String getVersionFromConfigServer() {
        return version;
    }

    @GetMapping("/name")
    public String getNameFromConfigServer() {
        return name;
    }

}
