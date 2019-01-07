package com.zcd.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-27 10:40
 **/

public class TestC {

    public static void main(String[] args) {


//        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),
//        ByteSource.Util.bytes(user.getAccount()),getName());

        String password="123456";
        String userName="zhangSan";
        int hashIterations=2;
        String encryptPassword=new SimpleHash("md5",password,
        ByteSource.Util.bytes(userName),hashIterations).toString();
        System.out.println(encryptPassword);
    }

}
