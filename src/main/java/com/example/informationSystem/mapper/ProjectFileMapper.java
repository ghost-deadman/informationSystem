package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.ProjectFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 16:51
 */
@Mapper
public interface ProjectFileMapper extends BaseMapper<ProjectFile> {

    /**
     * 按草稿查询所有文件id
     * @param projectDraftId 草稿id
     * @return 文件id数组
     */
    @Select("select project_file_id from project_file where project_draft_id = #{projectDraftId}")
    List<String> selectProjectFileIdByProjectDraftId(String projectDraftId);

    /**
     * 按草稿查询所有文件名称
     * @param projectDraftId 草稿id
     * @return 文件id数组
     */
    @Select("select name from project_file where project_draft_id = #{projectDraftId}")
    List<String> selectFileNameByProjectDraftId(String projectDraftId);

    /**
     * 获取属于该单位的项目的项目文件并按状态区分
     * @param unitId 单位id
     * @param firstStatus 第一个状态
     * @param secondStatus 最后一个状态
     * @return 项目文件数组
     */
    @Select("select f.* from project_file f, project p where f.project_id = p.project_id and p.unit_id = #{unitId} and p.create_status >= #{firstStatus} and p.create_status <= #{secondStatus}")
    List<ProjectFile> selectProjectFileByUnit(String unitId,Integer firstStatus,Integer secondStatus);

    /**
     * 查询该单位的某状态项目的项目文件
     * @param unitId 单位id
     * @param status 状态
     * @return 项目文件数组
     */
    @Select("select f.* from project_file f, project p where f.project_id = p.project_id and p.unit_id = #{unitId} and p.create_status == #{status}")
    List<ProjectFile> selectProjectFileByUnitAndStatus(String unitId, Integer status);

    /**
     * 获取属于该单位的项目的项目文件并按状态区分
     * @param unitId 单位id
     * @param firstStatus 第一个状态
     * @param secondStatus 最后一个状态
     * @param size 每页大小
     * @param page 页数
     * @return 项目文件数组
     */
    @Select("select f.* from project_file f, project p where f.project_id = p.project_id and p.unit_id = #{unitId} and p.create_status >= #{firstStatus} and p.create_status <= #{secondStatus} limit #{page},#{size}")
    List<ProjectFile> selectProjectFilePageByUnit(String unitId, Integer firstStatus,Integer secondStatus, long page, long size);

    /**
     * 按项目id查询文件
     * @param projectId 项目id
     * @return 项目文件
     */
    @Select("select * from project_file where project_id = #{projectId} And type = 0")
    List<ProjectFile> selectProjectFileByProjectId(String projectId);

    /**
     * 按项目id查询验收报告文件
     * @param projectId 项目id
     * @return 项目文件
     */
    @Select("select * from project_file where project_id = #{projectId} And type > 5")
    List<ProjectFile> selectInspectionProjectFileByProjectId(String projectId);

}
