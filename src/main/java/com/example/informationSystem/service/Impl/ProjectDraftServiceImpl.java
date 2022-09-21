package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectContext;
import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.mapper.ProjectDraftMapper;
import com.example.informationSystem.service.ProjectContextService;
import com.example.informationSystem.service.ProjectDraftService;
import com.example.informationSystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author pcdn
 */
@Service
public class ProjectDraftServiceImpl implements ProjectDraftService {

    @Autowired
    private ProjectDraftMapper projectDraftMapper;

    @Override
    public boolean addProjectDraft(ProjectDraft projectDraft) {
        projectDraftMapper.insert(projectDraft);
        return true;
    }

    @Override
    public boolean deleteProjectDraft(String id) {
        projectDraftMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean updateProjectDraft(ProjectDraft projectDraft) {

        //提交草稿
        if (projectDraft.getStatus() == 1) {

            //获取草稿
            ProjectDraft projectDraftNow = selectProjectDraftById(projectDraft.getProjectDraftId());

            ProjectService projectService = new ProjectServiceImpl();

            //获取项目
            Project project = projectService.selectProjectById(projectDraft.getProjectId());

            if (projectDraftNow == null || project == null) {

                return false;

            } else {

                //项目存储内容
                project.setProjectCategoryId(projectDraftNow.getProjectCategoryId());

                project.setProjectUserId(projectDraftNow.getProjectUserId());

                project.setType(projectDraftNow.getType());

                project.setUnitId(projectDraftNow.getUnitId());

                project.setCreateDate(LocalDateTime.now());

                //更新项目状态为申请中
                project.setCreateStatus(1);

                ProjectContextService projectContextService = new ProjectContextImpl();

                //项目内容
                ProjectContext projectContext = new ProjectContext();

                projectContext.setProjectContextId(String.valueOf(UUID.randomUUID()));

                projectContext.setDescribes(projectDraftNow.getDescribes());

                projectContext.setName(projectDraftNow.getName());

                if (projectContextService.addProjectContext(projectContext)) {

                    project.setProjectContextId(projectContext.getProjectContextId());

                } else {

                    return false;

                }

            }

            //更新草稿为只读
            projectDraftNow.setStatus(1);

            projectDraftMapper.updateById(projectDraftNow);

            return true;

        }

        //修改草稿
        projectDraftMapper.updateById(projectDraft);

        return true;
    }

    @Override
    public ProjectDraft selectProjectDraftById(String id) {
        return projectDraftMapper.selectById(id);
    }

    @Override
    public List<ProjectDraft> selectProjectDraftByProjectId(String projectId) {

        QueryWrapper<ProjectDraft> projectDraftQueryWrapper = new QueryWrapper<>();

        projectDraftQueryWrapper.eq("project_id", projectId);

        return projectDraftMapper.selectList(projectDraftQueryWrapper);
    }

}
