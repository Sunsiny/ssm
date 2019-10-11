package com.syc.ssm.service;

import com.syc.ssm.bean.User;


public interface UserService {
    User login(User user);

    //业务层:注册--->dao层:对应添加
    int register(User user);
}
