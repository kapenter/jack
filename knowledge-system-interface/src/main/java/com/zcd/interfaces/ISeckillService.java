package com.zcd.interfaces;

import com.zcd.entity.Seckill;

import java.util.List;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 14:52
 **/
public interface ISeckillService {

    List<Seckill> seckillList();


    Seckill selectById(Long seckillId);


}
