package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.ProjectCategory;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:01
 */
public interface ProjectCategoryService {

    /**
     * 添加项目类别数据
     * @param projectCategory 项目类别对象
     * @return 是否成功
     */
    boolean addProjectCategory(ProjectCategory projectCategory);

    /**
     * 更新项目类别数据
     * @param projectCategory 项目类别数据对象
     * @return 是否成功
     */
    boolean updateProjectCategory(ProjectCategory projectCategory);

    /**
     * 删除项目类别数据
     * @param id 项目类别id
     * @return 是否成功
     */
    boolean deleteProjectCategoryById(String id);

    /**
     * 查询项目类别
     * @param id 项目类别id
     * @return 项目类别对象
     */
    ProjectCategory selectProjectCategoryById(String id);

    /**
     * 查询所有项目类别数据
     * @return 项目类别数组对象
     */
    List<ProjectCategory> selectAll();


    /**
     * 分页查询
     * @param page 页数
     * @param size 每页数据条数
     * @return 分页对象
     */
    IPage<ProjectCategory> selectAll(long page, long size);
}
