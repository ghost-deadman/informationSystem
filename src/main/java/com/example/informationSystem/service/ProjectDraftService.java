package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.utils.Result;

import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectDraftService {
    /**
     * 增加项目草稿
     * @param projectDraft 项目草稿对象
     * @return 是否成功
     */
    boolean addProjectDraft(ProjectDraft projectDraft);

    /**
     * 删除项目草稿
     * @param id 草稿id
     * @return 是否成功
     */
    boolean deleteProjectDraft(String id);

    /**
     * 更新项目草稿
     * @param projectDraft 项目草稿
     * @return 是否成功
     */
    boolean updateProjectDraft(ProjectDraft projectDraft);

    /**
     * 通过id查询项目草稿
     * @param id 草稿id
     * @return 是否成功
     */
    ProjectDraft selectProjectDraftById(String id);

    /**
     * 通过项目id查询草稿
     * @param projectId 项目id
     * @return 草稿数组
     */
    List<ProjectDraft> selectProjectDraftByProjectId(String projectId);

}
