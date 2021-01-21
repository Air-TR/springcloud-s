package com.tr.springcloud.eurekafeign.client;

import com.tr.springcloud.eurekafeign.config.FeignConfig;
import com.tr.springcloud.eurekafeign.hystrix.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 在接口上加＠FeignClient 注解声明一个Feign Client，value 为远程调用其他服务的服务名，configuration 为FeignClient 的配置类
 *
 * @author TR
 * @date 2021/1/19 下午5:03
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeign {

    /**
     * 该方法通过Feign 来调用eureka-client 服务的“/hi”API接口
     * @param name
     * @return
     */
    @GetMapping("/hi/{name}")
    String hi(@PathVariable String name);

}
