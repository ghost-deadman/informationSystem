package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.entity.DTO.ProjectInspectionDTO;
import com.example.informationSystem.entity.ProjectInspection;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author pcdn
 */
@Mapper
public interface ProjectInspectionMapper extends BaseMapper<ProjectInspection> {


    /**
     * 按用户id查询项目扩展对象
     * @param userId id
     * @param offset 开始位置
     * @param status 状态
     * @param size 大小
     * @return 项目扩展
     */
    @Select("SELECT * FROM project_inspection where user_id = #{userId} And status = #{status} limit #{offset},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectInspectionProjectFileByProjectId")
            ),
            @Result(
                    property = "projectName",
                    javaType = String.class,
                    column = "project_id",
                    one = @One(select = "com.example.informationSystem.mapper.ProjectMapper.selectProjectNameById")
            ),
            @Result(property = "approvalOpinionId",column = "approval_opinion_id"),
            @Result(
                    property = "approvalOpinion",
                    javaType = ApprovalOpinion.class,
                    column = "approval_opinion_id",
                    one = @One(select = "com.example.informationSystem.mapper.ApprovalOpinionMapper.selectById")
            )
    })
    List<ProjectInspectionDTO> selectByUserAndStatusIdPage(long offset, long size, String userId, Integer status);

    /**
     * 通过项目id查询项目负责人id
     * @param projectId 项目id
     * @return 项目负责人id
     */
    @Select("select user_id from project_inspection where project_id = #{projectId}")
    String getUserIdByProject(String projectId);

    /**
     * 通过单位查询某状态项目验收
     * @param offset 开始
     * @param size 数量
     * @param unitId 单位id
     * @param status 状态
     * @return 项目验收
     */
    @Select("SELECT pi.* FROM project_inspection pi, project p where p.project_id = pi.project_id And p.unit_id = #{unitId}  And pi.status = #{status} limit #{offset},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectInspectionProjectFileByProjectId")
            ),
            @Result(
                    property = "projectName",
                    javaType = String.class,
                    column = "project_id",
                    one = @One(select = "com.example.informationSystem.mapper.ProjectMapper.selectProjectNameById")
            ),
            @Result(property = "approvalOpinionId",column = "approval_opinion_id"),
            @Result(
                    property = "approvalOpinion",
                    javaType = ApprovalOpinion.class,
                    column = "approval_opinion_id",
                    one = @One(select = "com.example.informationSystem.mapper.ApprovalOpinionMapper.selectById")
            )
    })
    List<ProjectInspectionDTO> selectByUnitIdAndStatusPage(long offset, long size, String unitId, int status);

    /**
     * 按状态查项目验收
     * @param offset 开始
     * @param pageSize 数量
     * @param status 状态
     * @return 项目验收扩展类
     */
    @Select("SELECT * FROM project_inspection where status = #{status} limit #{offset},#{size}")
    @Results({
            @Result(property = "projectId",column = "project_id"),
            @Result(
                    property = "projectFileList", // 被包含对象的变量名
                    javaType = List.class, // 被包含对象的实际数据类型
                    column = "project_id", // 根据查询出的classes表的id字段来查询student表
                    many = @Many(select = "com.example.informationSystem.mapper.ProjectFileMapper.selectInspectionProjectFileByProjectId")
            ),
            @Result(
                    property = "projectName",
                    javaType = String.class,
                    column = "project_id",
                    one = @One(select = "com.example.informationSystem.mapper.ProjectMapper.selectProjectNameById")
            ),
            @Result(property = "approvalOpinionId",column = "approval_opinion_id"),
            @Result(
                    property = "approvalOpinion",
                    javaType = ApprovalOpinion.class,
                    column = "approval_opinion_id",
                    one = @One(select = "com.example.informationSystem.mapper.ApprovalOpinionMapper.selectById")
            )
    })
    List<ProjectInspectionDTO> selectByStatusPage(long offset, long pageSize, int status);

    /**
     * 通过项目验收id查询项目负责人id
     * @param projectInspectionId 项目验收id
     * @return 项目负责人id
     */
    @Select("select user_id from project_inspection where project_inspection_id = #{projectInspectionId}")
    String getUserIdById(String projectInspectionId);

    @Select("select project_id from project_inspection where project_inspection_id = #{projectInspectionId}")
    String getProjectIdById(String projectInspectionId);
}
