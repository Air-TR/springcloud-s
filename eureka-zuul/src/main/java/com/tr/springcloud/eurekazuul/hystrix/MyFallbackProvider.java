package com.tr.springcloud.eurekazuul.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TR
 * @date 2021/1/20 下午7:30
 */
@Component
class MyFallbackProvider implements FallbackProvider {

    /**
     * getRoute()方法，用于指定熔断功能应用于哪些路由的服务
     * 可以指定具体的服务名称，比如eureka-client
     * 也可以指定*，代表此熔断器应用到所有的服务上
     */
    @Override
    public String getRoute() {
        return "eureka-client";
//        return "*";
    }

    /**
     * fallbackResponse()方法为进入熔断功能时执行的逻辑
     */
    @Override
    public ClientHttpResponse fallbackResponse(String var1, Throwable var2) {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务的请求失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 微服务出现宕机后，客户端再请求时就会返回 fallback 等字样的字符串提示；
             * 这里定义出发 Hystrix 后返回给客户端的信息
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("This is the Zuul Hystrix Fallback.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                // 和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }

}
