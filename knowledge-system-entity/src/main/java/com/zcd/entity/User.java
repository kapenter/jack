package com.zcd.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-06 16:03
 **/
@Data
public class User {

    private Integer  id;

    private String  userName ;

    private  String  password;

    private String  account;

    private Date createTime ;

    private Date  updateTime  ;

    private String locked ;

}
