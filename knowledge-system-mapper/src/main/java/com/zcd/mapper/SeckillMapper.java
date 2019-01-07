package com.zcd.mapper;

import com.zcd.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 14:56
 **/
@Repository
public interface SeckillMapper {

    @Select( " select   * from  seckill " )
    List<Seckill> seckillList();


    @Select(" select  * from  seckill where  seckill_id=#{seckillId} ")
    Seckill selectById(@Param("seckillId") Long seckillId);
}
