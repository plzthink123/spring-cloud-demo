package com.think123.consumer.client;

import com.think123.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = FallBack.class)
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id")Integer id);
}
