package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectContext;
import com.example.informationSystem.entity.ProjectFile;

/**
 * @author pcdn
 */
public interface ProjectContextService {

    /**
     * 添加项目内容
     * @param projectContext 项目内容对象
     * @return 是否成功
     */
    boolean addProjectContext(ProjectContext projectContext);

    /**
     * 更新项目内容
     * @param projectContext 项目内容对象
     * @return 是否成功
     */
    boolean updateProjectContextById(ProjectContext projectContext);

    /**
     * 删除项目内容
     * @param id 项目内容id
     * @return 是否成功
     */
    boolean deleteProjectContextById(String id);

    /**
     * 按id查询项目内容
     * @param id 项目内容id
     * @return 项目内容对象
     */
    ProjectContext selectProjectContextById(String id);


}
