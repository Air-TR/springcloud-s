package com.tr.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope 注解必须放在Controller层上，否则请求 http://localhost:8770/actuator/bus-refresh 正确后也读不到最新配置。
 * post 请求 http://localhost:8770/actuator/bus-refresh 正确响应后返回 204 code。
 *
 * @author TR
 * @date 2021/1/21 上午11:24
 */
@RestController
@RefreshScope
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
