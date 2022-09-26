package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：zqy
 * @date ：Created in 2022/9/14 15:43
 */
@Mapper
public interface SubjectMapper  extends BaseMapper<Subject> {
    /**
     * 通过姓名查询用户信息并分页
     * @param page MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param name
     * @return
     */
    Page<Subject> selectPageVo(@Param("page") Page<Subject> page, @Param("name") String name);

}

