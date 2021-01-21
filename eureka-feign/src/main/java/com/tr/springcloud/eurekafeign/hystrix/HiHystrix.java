package com.tr.springcloud.eurekafeign.hystrix;

import com.tr.springcloud.eurekafeign.client.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @author TR
 * @date 2021/1/20 下午5:32
 */
@Component
public class HiHystrix implements EurekaClientFeign {

    @Override
    public String hi(String name) {
        return "Hi " + name + ", this is Feign Hystrix Fallback";
    }
}
