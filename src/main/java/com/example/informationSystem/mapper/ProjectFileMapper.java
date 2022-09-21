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
}
