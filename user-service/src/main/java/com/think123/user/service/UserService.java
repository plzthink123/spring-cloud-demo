package com.think123.user.service;

import com.think123.user.mapper.UserMapper;
import com.think123.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;
    public User queryById(Integer id){

        return userMapper.selectByPrimaryKey(id);
    }
}