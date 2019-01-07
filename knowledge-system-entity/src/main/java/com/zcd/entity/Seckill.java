package com.zcd.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 14:46
 **/
@Data
public class Seckill implements Serializable {

    private Long seckillId;

    private String name;

    private Integer number;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Integer goodsId;

    private BigDecimal price;

    private String status;

    private String createUser;


}
