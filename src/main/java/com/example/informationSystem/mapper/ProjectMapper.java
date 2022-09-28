package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectCategory;
import com.example.informationSystem.entity.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author pcdn
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {


    /**
     * 按用户id查询项目扩展对象
     * @param createStatus 状态
     * @param userId id
     * @param page 页数
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project where project_user_id = #{userId} and create_status = #{createStatus} limit #{page},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectProjectFileByProjectId")
            ),
            @Result(property = "projectCategoryId",column = "project_category_id"),
            @Result(
                    property = "projectCategory", // 被包含对象的变量名
                    javaType = ProjectCategory.class, // 被包含对象的实际数据类型
                    column = "project_category_id", // 根据查询出的classes表的id字段来查询student表
                    one = @One(select = "com.example.informationSystem.mapper.ProjectCategoryMapper.selectById")
            ),
            @Result(property = "unitId",column = "unit_id"),
            @Result(
                    property = "unit",
                    javaType = Unit.class,
                    column = "unit_id",
                    one = @One(select = "com.example.informationSystem.mapper.UnitMapper.selectById")
            )
    })
    List<ProjectDTO> selectProjectByCreateStatusAndUserPage(int createStatus,String userId, long page, long size);

    /**
     * 按用户id查询项目扩展对象
     * @param createStatus 状态
     * @param unitId id
     * @param page 页数
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project where unit_id = #{unitId} and create_status = #{createStatus} limit #{page},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectProjectFileByProjectId")
            ),
            @Result(property = "projectCategoryId",column = "project_category_id"),
            @Result(
                    property = "projectCategory", // 被包含对象的变量名
                    javaType = ProjectCategory.class, // 被包含对象的实际数据类型
                    column = "project_category_id", // 根据查询出的classes表的id字段来查询student表
                    one = @One(select = "com.example.informationSystem.mapper.ProjectCategoryMapper.selectById")
            ),
            @Result(property = "unitId",column = "unit_id"),
            @Result(
                    property = "unit",
                    javaType = Unit.class,
                    column = "unit_id",
                    one = @One(select = "com.example.informationSystem.mapper.UnitMapper.selectById")
            )
    })
    List<ProjectDTO> selectProjectByCreateStatusAndUnitPage(int createStatus, String unitId, long page, long size);

    /**
     * 按创建状态获取项目扩展对象
     * @param createStatus 创建状态
     * @param page 开始
     * @param size 数量
     * @return 项目扩展对象
     */
    @Select("SELECT * FROM project where create_status = #{createStatus} limit #{page},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectProjectFileByProjectId")
            ),
            @Result(property = "projectCategoryId",column = "project_category_id"),
            @Result(
                    property = "projectCategory", // 被包含对象的变量名
                    javaType = ProjectCategory.class, // 被包含对象的实际数据类型
                    column = "project_category_id", // 根据查询出的classes表的id字段来查询student表
                    one = @One(select = "com.example.informationSystem.mapper.ProjectCategoryMapper.selectById")
            ),
            @Result(property = "unitId",column = "unit_id"),
            @Result(
                    property = "unit",
                    javaType = Unit.class,
                    column = "unit_id",
                    one = @One(select = "com.example.informationSystem.mapper.UnitMapper.selectById")
            )
    })
    List<ProjectDTO> selectProjectByCreateStatusPage(int createStatus, long page, long size);
}
