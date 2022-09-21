package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.mapper.ProjectFileMapper;
import com.example.informationSystem.service.ProjectFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 14:42
 */
@Service
public class ProjectFileServiceImpl implements ProjectFileService {

    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Override
    public boolean addProjectFile(ProjectFile projectFile) {

        System.out.println(projectFile);

        projectFileMapper.insert(projectFile);

        System.out.println("AWd");

        return true;

    }

    @Override
    public boolean updateProjectFileById(ProjectFile projectFile) {

        projectFileMapper.updateById(projectFile);

        return true;

    }

    @Override
    public boolean deleteProjectFileById(String id) {

        projectFileMapper.deleteById(id);

        return true;

    }

    @Override
    public ProjectFile selectProjectFileById(String id) {

        return projectFileMapper.selectById(id);

    }

    @Override
    public List<ProjectFile> selectProjectFileByUnit(String unitId) {
        return projectFileMapper.selectProjectFileByUnit(unitId,1,3);
    }

    @Override
    public List<ProjectFile> selectProjectFileByUnitAndStatus(String unitId, Integer status) {

        return projectFileMapper.selectProjectFileByUnitAndStatus(unitId,status);

    }

}
