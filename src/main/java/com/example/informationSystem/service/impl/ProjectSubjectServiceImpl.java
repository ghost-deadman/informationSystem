package com.example.informationSystem.service.impl;

import com.example.informationSystem.entity.ProjectSubject;
import com.example.informationSystem.mapper.ProjectSubjectMapper;
import com.example.informationSystem.service.ProjectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectSubjectServiceImpl implements ProjectSubjectService {
    @Autowired
    private ProjectSubjectMapper projectSubjectMapper;
    @Override
    public boolean addProjectSubject(ProjectSubject projectSubject) {
        projectSubjectMapper.insert(projectSubject);
        return true;
    }

    @Override
    public boolean deleteProjectSubject(String id) {
        projectSubjectMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean updateProjectSubject(ProjectSubject projectSubject) {
        projectSubjectMapper.updateById(projectSubject);
        return false;
    }

    @Override
    public ProjectSubject selectProjectSubjectById(String id) {
        projectSubjectMapper.selectById(id);
        return null;
    }

    @Override
    public List<ProjectSubject> selectProjectSubject() {
        return projectSubjectMapper.selectList(null);
    }
}
