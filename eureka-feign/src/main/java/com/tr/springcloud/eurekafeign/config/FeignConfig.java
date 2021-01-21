package com.tr.springcloud.eurekafeign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author TR
 * @date 2021/1/19 下午4:52
 */
@Configuration
public class FeignConfig {

    /**
     * 在该类中注入Retryer的Bean，覆盖掉默认的Retryer的Bean，从而达到自定义配置的目的。
     * 例如Feign 默认的配置在请求失败后，重试次数为0，即不重试（ Retry er.NEVER_RETRY ）。
     * 更改为FeignClient 请求失败后：重试间隔为100毫秒，最大重试时间为1秒，重试次数5次。
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }

}
