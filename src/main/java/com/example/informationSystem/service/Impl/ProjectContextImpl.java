package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.ProjectContext;
import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.mapper.ProjectContextMapper;
import com.example.informationSystem.service.ProjectContextService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/19 9:44
 */
public class ProjectContextImpl implements ProjectContextService {

    @Autowired
    private ProjectContextMapper projectContextMapper;

    @Override
    public boolean addProjectContext(ProjectContext projectContext) {

        projectContextMapper.insert(projectContext);

        return true;

    }

    @Override
    public boolean updateProjectContextById(ProjectContext projectContext) {

        projectContextMapper.updateById(projectContext);

        return true;

    }

    @Override
    public boolean deleteProjectContextById(String id) {

        projectContextMapper.deleteById(id);

        return false;

    }

    @Override
    public ProjectContext selectProjectContextById(String id) {

        return projectContextMapper.selectById(id);

    }
}
