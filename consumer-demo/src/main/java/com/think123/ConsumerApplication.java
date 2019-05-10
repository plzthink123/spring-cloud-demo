package com.think123;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker//服务的熔断 使用hystix
//@EnableDiscoveryClient   使用Eureka
//@SpringBootApplication
/*@SpringCloudApplication= @SpringBootApplication
                          +@EnableDiscoveryClient
                          +@EnableCircuitBreaker
*/
@EnableFeignClients//使用feign路由
@SpringCloudApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}