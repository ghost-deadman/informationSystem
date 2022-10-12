package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.ProjectDraftDTO;
import com.example.informationSystem.entity.*;
import com.example.informationSystem.mapper.*;
import com.example.informationSystem.service.ProjectDraftService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author pcdn
 */
@Service
public class ProjectDraftServiceImpl implements ProjectDraftService {

    @Autowired
    private ProjectDraftMapper projectDraftMapper;

    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectContextMapper projectContextMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public boolean addProjectDraft(ProjectDraft projectDraft,List<String> pathList) {

        projectDraft.setCreateDate(LocalDateTime.now());

        //将该草稿含有的文件依次放入
        for (String path : pathList) {

            String fileName = path.substring(path.lastIndexOf("\\") + 1);

            ProjectFile projectFile = ProjectFileServiceImpl.getInformation(projectDraft.getProjectId(), fileName, path,0);

            projectFileMapper.insert(projectFile);

        }

        //添加草稿数据
        projectDraftMapper.insert(projectDraft);

        return true;

    }


    @Override
    public boolean deleteProjectDraft(String id) {

        //按id删除草稿
        projectDraftMapper.deleteById(id);

        QueryWrapper<ProjectFile> projectFileQueryWrapper = new QueryWrapper<>();

        //将该草稿对应的文件删除
        projectFileQueryWrapper.eq("project_draft_id",id);

        projectFileMapper.delete(projectFileQueryWrapper);

        return true;
    }


    @Override
    public boolean updateProjectDraft(ProjectDraft projectDraft) {

        //文件不更新 直接更新
        projectDraftMapper.updateById(projectDraft);

        return true;

    }

    @Override
    public boolean updateProjectDraft(ProjectDraft projectDraft,List<String> pathList) {

        //有文件要更新文件
        QueryWrapper<ProjectFile> projectFileQueryWrapper = new QueryWrapper<>();

        projectFileQueryWrapper.eq("project_draft_id",projectDraft.getProjectDraftId());

        //删除文件 重新添加
        projectFileMapper.delete(projectFileQueryWrapper);

        //文件放入
        for (String path : pathList) {

            String fileName = path.substring(path.lastIndexOf("\\") + 1);

            ProjectFile projectFile = ProjectFileServiceImpl.getInformation(projectDraft.getProjectId(), fileName, path,0);

            projectFileMapper.insert(projectFile);


        }

        //更新草稿数据
        projectDraftMapper.updateById(projectDraft);

        return true;

    }


    @Override
    public ProjectDraftDTO selectProjectDraftById(String id) {

        //返回扩展对象
        return projectDraftMapper.selectProjectDraftDtoById(id);

    }

    @Override
    public List<ProjectDraft> selectProjectDraftByProjectId(String projectId) {

        //获取草稿数组 然后全部扩展成扩展对象
        QueryWrapper<ProjectDraft> projectDraftQueryWrapper = new QueryWrapper<>();

        projectDraftQueryWrapper.eq("project_id", projectId);

        projectDraftQueryWrapper.orderByAsc("create_date");

        return projectDraftMapper.selectList(projectDraftQueryWrapper);

    }

    @Override
    public IPage<ProjectDraft> selectProjectDraftByProjectId(String projectId, long page, long size) {

        //添加分页功能
        QueryWrapper<ProjectDraft> projectDraftQueryWrapper = new QueryWrapper<>();

        IPage<ProjectDraft> projectDraftPage = new Page<>(page, size);

        projectDraftQueryWrapper.eq("project_id", projectId);

        projectDraftQueryWrapper.orderByAsc("create_date");

        projectDraftMapper.selectPage(projectDraftPage, projectDraftQueryWrapper);

        return projectDraftPage;

    }

    @Override
    public boolean submitProjectDraft(String projectDraftId) {

        //提交草稿为正式项目
        ProjectDraft projectDraft = projectDraftMapper.selectById(projectDraftId);

        if (projectDraft == null) {

            return false;

        }

        //获取项目
        Project project = projectMapper.selectById(projectDraft.getProjectId());

        if (project == null) {

            return false;

        }

        UpdateWrapper<ProjectFile> projectFileUpdateWrapper = new UpdateWrapper<>();

        projectFileUpdateWrapper.eq("project_draft_id",projectDraftId);

        projectFileUpdateWrapper.set("type",1);

        projectFileMapper.update(null,projectFileUpdateWrapper);

        //项目存储内容
        project.setProjectCategoryId(projectDraft.getProjectCategoryId());

        project.setProjectUserId(projectDraft.getProjectUserId());

        project.setType(projectDraft.getType());

        project.setUnitId(projectDraft.getUnitId());

        project.setCreateDate(LocalDateTime.now());

        //更新项目状态为申请中
        project.setCreateStatus(1);

        //项目内容
        ProjectContext projectContext = new ProjectContext();

        projectContext.setProjectContextId(String.valueOf(UUID.randomUUID()));


        if (projectContextMapper.insert(projectContext) > 0) {

           // project.setProjectContextId(projectContext.getProjectContextId());

            projectMapper.updateById(project);

        } else {

            return false;

        }

        return true;


    }

    @Override
    public IPage<ProjectDraft> selectAllProjectDraftByUserId(String userId, long page, long size) {

        IPage<ProjectDraft> projectDraftPage = new Page<>();

        QueryWrapper<ProjectDraft> projectDraftQueryWrapper = new QueryWrapper<>();

        projectDraftQueryWrapper.eq("project_user_id",userId);

        projectDraftMapper.selectPage(projectDraftPage,projectDraftQueryWrapper);

        return projectDraftPage;

    }

}
