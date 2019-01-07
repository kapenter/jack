package com.zcd.service;

import com.github.pagehelper.PageInfo;
import com.zcd.entity.Seckill;
import com.zcd.interfaces.ISeckillService;
import com.zcd.mapper.SeckillMapper;
import com.zcd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 14:54
 **/
@Service
public class SeckillServiceImp implements ISeckillService {

    @Autowired
    private SeckillMapper seckillMapper ;

    @Override
    public List<Seckill> seckillList() {
        return seckillMapper.seckillList();
    }

    @Override
    public Seckill selectById(Long seckillId) {
        return seckillMapper.selectById(seckillId);
    }
}
