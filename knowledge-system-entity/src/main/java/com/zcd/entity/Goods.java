package com.zcd.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 16:46
 **/
@Data
public class Goods implements Serializable {

    private Integer goodsId;
    private String photoUrl;
    private String name;
    private String price;
    private Date createTime;
    private String introduce;
    private byte[] photoImage;

}
