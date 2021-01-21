package com.tr.springcloud.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author TR
 * @date 2021/1/19 下午3:06
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientCp1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCp1Application.class, args);
	}

}
