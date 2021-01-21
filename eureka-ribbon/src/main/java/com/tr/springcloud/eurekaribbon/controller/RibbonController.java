package com.tr.springcloud.eurekaribbon.controller;

import com.tr.springcloud.eurekaribbon.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TR
 * @date 2021/1/19 下午3:51
 */
@RestController
public class RibbonController {

    @Resource
    RibbonService ribbonService;

    /**
     * 调用 ribbonService 的 hi() 方法
     */
    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        return ribbonService.hi(name);
    }

}
