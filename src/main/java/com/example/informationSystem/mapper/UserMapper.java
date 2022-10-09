package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过 用户名获取用户
     * @return 用户信息
     */
    User getOneByUserName(String userName);
}
