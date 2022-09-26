package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectDraft;

import java.util.List;

public interface ProjectDraftService {
    /**
     * 增加项目草稿
     * @param projectDraft
     * @return
     */
    boolean addProjectDraft(ProjectDraft projectDraft);

    /**
     * 删除项目草稿
     * @param id
     * @return
     */
    boolean deleteProjectDraft(String id);

    /**
     * 更新项目草稿
     * @param projectDraft
     * @return
     */
    boolean updateProjectDraft(ProjectDraft projectDraft);

    /**
     * 通过id查询项目草稿
     * @param id
     * @return
     */
    ProjectDraft selectProjectDraftById(String id);

    List<ProjectDraft> selectProjectDraft();
}
