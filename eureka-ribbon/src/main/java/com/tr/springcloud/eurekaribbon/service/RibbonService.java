package com.tr.springcloud.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author TR
 * @date 2021/1/19 下午3:41
 */
@Service
public class RibbonService {

    @Resource
    RestTemplate restTemplate;

    /**
     * 1.在该类的hi()方法用restTemplate 调用eureka-client 的API接口，Uri上不需要使用硬编码（比如IP），只需要写服务名eureka-client即可
     * 程序会根据服务名称eureka-client 到Eureka-server 注册中心去自动获取IP和端口信息。
     *
     * 2.在 eureka-ribbon 服务中开启 Hystrix 功能，只需要引入Hystrix 相关依赖并在这里配上@HystrixCommand 注解即可。
     */
    @HystrixCommand(fallbackMethod = "fallbackHi") // 此注解加在 Controller 层也一样
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi/" + name, String.class);
    }

    public String fallbackHi(String name) {
        return "Hi " + name + ", this is Ribbon Hystrix Fallback";
    }

}
