package com.zcd.service;

import com.zcd.entity.Goods;
import com.zcd.interfaces.IGoodService;
import com.zcd.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2019-01-04 17:07
 **/
@Service
public class GoodServiceImp  implements IGoodService {

    @Autowired
    private GoodsMapper goodsMapper ;

    @Override
    public byte[] getPhotoImg(Integer goodId) {
        Goods goods=goodsMapper.selectGoodById(goodId);
        return goods.getPhotoImage();
    }
}
