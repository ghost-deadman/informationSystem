package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.utils.Pager;

import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectFileService {

    /**
     * 添加申请材料
     * @param projectFile 申请材料对象
     * @return 是否成功
     */
    boolean addProjectFile(ProjectFile projectFile);

    /**
     * 更新申请材料
     * @param projectFile 申请材料对象
     * @return 是否成功
     */
    boolean updateProjectFileById(ProjectFile projectFile);

    /**
     * 删除申请材料
     * @param id 申请材料id
     * @return 是否成功
     */
    boolean deleteProjectFileById(String id);

    /**
     * 按id查询项目材料文件
     * @param id 项目材料id
     * @return 项目材料对象
     */
    ProjectFile selectProjectFileById(String id);


    /**
     * 通过单位id查询项目文件
     * @param unitId 单位id
     * @return 项目文件数组对象
     */
    List<ProjectFile> selectProjectFileByUnit(String unitId);

    /**
     * 通过单位和状态查询项目文件
     * @param unitId 单位id
     * @param status 状态
     * @return 项目文件数组对象
     */
    List<ProjectFile> selectProjectFileByUnitAndStatus(String unitId, Integer status);

    /**
     * 通过单位分页查询
     * @param unitId 单位id
     * @param page 页数
     * @param size 每页数据条数
     * @return 数据
     */
    Pager<ProjectFile> selectProjectFileByUnit(String unitId, long page, long size);
}
