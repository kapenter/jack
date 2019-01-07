package com.zcd.service;

import com.zcd.entity.User;
import com.zcd.interfaces.IUserInterface;
import com.zcd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-24 10:15
 **/
@Service
public class UserServiceImp   implements IUserInterface {


    @Autowired
    private UserMapper userMapper ;

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public User selectUserByName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }
}
