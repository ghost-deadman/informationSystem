package com.example.informationSystem.service.impl;

import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.mapper.ProjectDraftMapper;
import com.example.informationSystem.service.ProjectDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        projectDraftMapper.updateById(projectDraft);
        return true;
    }

    @Override
    public List<ProjectDraft> selectProjectDraft() {
        return projectDraftMapper.selectList(null);
    }

    @Override
    public ProjectDraft selectProjectDraftById(String id) {
        return projectDraftMapper.selectById(id);
    }
}
