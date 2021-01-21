package com.tr.springcloud.eurekafeign.service;

import com.tr.springcloud.eurekafeign.client.EurekaClientFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author TR
 * @date 2021/1/19 下午5:15
 */
@Service
public class HiService {

    @Resource
    EurekaClientFeign eurekaClientFeign;

    /**
     * 注入EurekaClientFeign 的Bean，通过EurekaClientFeign 去调用 hi() 方法
     * @param name
     * @return
     */
    public String hi(String name) {
        return eurekaClientFeign.hi(name);
    }

}
