package com.zcd.mapper;

import com.zcd.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-07 13:46
 **/
@Repository
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User selectUserById(Integer id);


    @Select(  " select  * from  user where  account=#{userName} " )
    User selectUserByUserName(@Param("userName") String userName);
}
