package com.think123.consumer.client;

import com.think123.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 熔断接口实现类
 */
@Component
public class FallBack implements UserClient {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setName("未知用户");
        return user;
    }
}