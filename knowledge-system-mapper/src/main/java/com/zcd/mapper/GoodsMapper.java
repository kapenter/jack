package com.zcd.mapper;

import com.zcd.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 17:08
 **/
@Repository
public interface GoodsMapper {

    Goods   selectGoodById(@Param("goodId") Integer goodId);

}
