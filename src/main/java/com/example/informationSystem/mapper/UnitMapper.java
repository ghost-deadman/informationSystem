package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 8:57
 */

@Mapper
public interface UnitMapper extends BaseMapper<Unit> {

    /**
     * 获取单位名称
     * @param id id
     * @return 名称
     */
    @Select("select name unitName from unit where unit_id = #{id}")
    List<String> selectUnitNameById(String id);

}
