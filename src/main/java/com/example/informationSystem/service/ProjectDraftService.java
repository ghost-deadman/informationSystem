package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.DTO.ProjectDraftDTO;
import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.entity.VO.ProjectDraftVO;
import com.example.informationSystem.utils.Result;

import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectDraftService {
    /**
     * 增加项目草稿
     * @param projectDraft 项目草稿对象
     * @param pathList 文件路径数组
     * @return 是否成功
     */
    boolean addProjectDraft(ProjectDraft projectDraft, List<String> pathList);

    /**
     * 删除项目草稿
     * @param id 草稿id
     * @return 是否成功
     */
    boolean deleteProjectDraft(String id);

    /**
     * 更新项目草稿
     * @param projectDraft 项目扩展草稿
     * @return 是否成功
     */
    boolean updateProjectDraft(ProjectDraft projectDraft);

    /**
     * 更新带文件的项目草稿
     * @param projectDraft 项目草稿
     * @param pathList 文件路径数组
     * @return 是否成功
     */
    boolean updateProjectDraft(ProjectDraft projectDraft, List<String> pathList);

    /**
     * 通过id查询项目草稿
     * @param id 草稿id
     * @return 是否成功
     */
    ProjectDraftDTO selectProjectDraftById(String id);

    /**
     * 通过项目id查询草稿
     * @param projectId 项目id
     * @return 草稿数组
     */
    List<ProjectDraft> selectProjectDraftByProjectId(String projectId);

    /**
     * 分页通过项目id草稿
     * @param projectId 项目id
     * @param page 页数
     * @param size 页面大小
     * @return 页面数据
     */
    IPage<ProjectDraft> selectProjectDraftByProjectId(String projectId, long page, long size);


    /**
     * 提交草稿 提交项目
     * @param projectDraftId 项目草稿id
     * @return 是否成功
     */
    boolean submitProjectDraft(String projectDraftId);

    /**
     * 按用户名分页查询
     * @param userId 用户id
     * @param page 页数
     * @param size 大小
     * @return 草稿数组
     */
    IPage<ProjectDraft> selectAllProjectDraftByUserId(String userId, long page, long size);
}
