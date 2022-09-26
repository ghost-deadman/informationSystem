package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectCategory;

import java.util.List;

public interface ProjectCategoryService {
    /**
     * 增加项目类别记录
     * @param projectCategory
     * @return
     */
    boolean addProjectCategory(ProjectCategory projectCategory);

    /**
     * 删除项目类别记录
     * @param id
     * @return
     */
    boolean deleteProjectCategory(String id);

    /**
     * 更新项目类别记录
     * @param projectCategory
     * @return
     */
    boolean updateProjectCategory(ProjectCategory projectCategory);

    /**
     * id查询项目类别记录
     * @param id
     * @return
     */
    ProjectCategory selectProjectCategoryById(String id);

    /**
     * 查询所有项目类别记录
     * @return
     */
    List<ProjectCategory> selectProjectCategory();

}
