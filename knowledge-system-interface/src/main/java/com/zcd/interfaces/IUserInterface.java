package com.zcd.interfaces;

import com.zcd.entity.User;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-07 14:06
 **/
public interface IUserInterface {

    User selectUserById(Integer id);


    User selectUserByName(String userName);
}
