package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.ArrangePlan;
import com.example.informationSystem.entity.DTO.ArrangePlanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pcdn
 */
@Mapper
public interface ArrangePlanMapper extends BaseMapper<ArrangePlan> {

    /**
     *通过项目id获取预算安排数组
     * @param projectId 项目id
     * @return 结果
     */
    @Select("SELECT ap.arrange_plan_id, ap.title, ap.money,ap.describes, ap.project_id, ap.date " +
            "FROM arrange_plan ap " +
            "WHERE arrange_plan_id = #{projectId}")
    List<ArrangePlanDTO> getListByProjectId(String projectId);

}
