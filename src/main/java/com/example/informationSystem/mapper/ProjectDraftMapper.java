package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.DTO.ProjectDraftDTO;
import com.example.informationSystem.entity.ProjectDraft;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Locale;

/**
 * @author pcdn
 */
@Mapper
public interface ProjectDraftMapper extends BaseMapper<ProjectDraft> {

    /**
     * 查询项目草稿扩展对象
     * @param id 项目草稿id
     * @return 项目草稿扩展对象
     */
    @Select("SELECT * FROM project_draft")
    @Results({
            @Result(
                    property = "projectFileIdList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_draft_id", // 根据查询出的classes表的id字段来查询student表
                    /*
                    many、@Many 一对多查询的固定写法
                    select属性：指定调用哪个接口中的哪个查询方法
                    */
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectProjectFileIdByProjectDraftId")
            ),
            @Result(
                    property = "fileNameList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_draft_id", // 根据查询出的classes表的id字段来查询student表
                    /*
                    many、@Many 一对多查询的固定写法
                    select属性：指定调用哪个接口中的哪个查询方法
                    */
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectFileNameByProjectDraftId")
            ),
            @Result(
                    property = "unitName",
                    javaType = String.class,
                    column = "unit_id",
                    one = @One(select = "com.example.informationSystem.mapper.UnitMapper.selectUnitNameById")
            )
    })
    ProjectDraftDTO selectProjectDraftDtoById(String id);

}
