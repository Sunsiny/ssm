package com.syc.ssm.service.impl;

import com.syc.ssm.bean.User;
import com.syc.ssm.mapper.UserMapper;
import com.syc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        List<User> users = userMapper.getUserByName(user.getUsername(), user.getPassword());
       // System.out.println("users:"+users);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public int register(User user) {
        return userMapper.insertUser(user);
    }
}
