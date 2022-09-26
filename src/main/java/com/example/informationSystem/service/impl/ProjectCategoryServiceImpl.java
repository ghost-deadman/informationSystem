package com.example.informationSystem.service.impl;

import com.example.informationSystem.entity.ProjectCategory;
import com.example.informationSystem.mapper.ProjectCategoryMapper;
import com.example.informationSystem.service.ProjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectCategoryServiceImpl implements ProjectCategoryService {
    @Autowired
    private ProjectCategoryMapper projectCategoryMapper;

    @Override
    public boolean addProjectCategory(ProjectCategory projectCategory) {
        projectCategoryMapper.insert(projectCategory);
        return true;
    }

    @Override
    public boolean deleteProjectCategory(String id) {
        projectCategoryMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean updateProjectCategory(ProjectCategory projectCategory) {
        projectCategoryMapper.updateById(projectCategory);
        return true;
    }

    @Override
    public ProjectCategory selectProjectCategoryById(String id) {
        return projectCategoryMapper.selectById(id);
    }

    @Override
    public List<ProjectCategory> selectProjectCategory() {
        return projectCategoryMapper.selectList(null);
    }
}
