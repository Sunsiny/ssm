package com.syc.ssm.mapper;

import com.syc.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //@Select("select * from t_user where username=#{username} and password = #{password} ")
    List<User> getUserByName(@Param("username") String username, @Param("password")String password);

    //@Insert("insert into ...")
    int insertUser(User user);
}
