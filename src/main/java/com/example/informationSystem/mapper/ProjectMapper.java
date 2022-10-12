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
     * 按用户id和创建状态查询项目扩展对象
     * @param createStatus 状态
     * @param userId id
     * @param page 页数
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project where project_user_id = #{userId} and create_status = #{createStatus} limit #{page},#{size};")
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
     * 按用户id查询和执行状态项目扩展对象
     * @param executeStatus 状态
     * @param userId id
     * @param page 页数
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project where project_user_id = #{userId} and execute_status = #{executeStatus} limit #{page},#{size};")
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
    List<ProjectDTO> selectProjectByExecuteStatusAndUserPage(int executeStatus, String userId, long page, long size);

    /**
     * 按用户id查询项目扩展对象
     * @param userId id
     * @param page 开始位置
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project where project_user_id = #{userId} limit #{page},#{size};")
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
    List<ProjectDTO> selectProjectByUserPage(String userId, long page, long size);

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

    /**
     * 按项目查询项目名称
     * @param projectId 项目id
     * @return 项目名称
     */
    @Select("select project_name from project where project_id = #{projectId}")
    String selectProjectNameById(String projectId);

    /**
     * 将项目还原为草稿状态
     * @param projectId 项目id
     */
    @Update("update project set create_status = 0,execute_status = 0 where project_id = #{projectId}")
    void updateProjectCreateStatusToStartById(String projectId);

    /**
     *通过项目id查询项目扩展对象
     * @param projectId 项目id
     * @return 项目扩展类
     */
    @Select("SELECT * FROM project where project_id = #{projectId}")
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
    ProjectDTO selectProjectByProjectId(String projectId);


    @Select("select count(*) from project p,unit u where p.unit_id = u.unit_id and u.name = #{name}")
    Integer selectProjectUnitCount(String name);

    @Select("select project_id from project where project_budget_id = #{pbId}")
    String getProjectIdByProjectBudgetId(String pbId);

}
