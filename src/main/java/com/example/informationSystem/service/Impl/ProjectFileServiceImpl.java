package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.mapper.ProjectFileMapper;
import com.example.informationSystem.service.ProjectFileService;
import com.example.informationSystem.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

        projectFileMapper.insert(projectFile);

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

    @Override
    public Pager<ProjectFile> selectProjectFileByUnit(String unitId, long page, long size) {

        Pager<ProjectFile> projectFilePager = new Pager<>(page,size);

        List<ProjectFile> projectFileList = projectFileMapper.selectProjectFilePageByUnit(unitId,1,3,projectFilePager.getOffset(),size);

        projectFilePager.setDataList(projectFileList);

        return projectFilePager;

    }

    /**
     * 获取文件相关信息存储项目文件对象中
     * @param fileName 文件名称
     * @return 项目文件对象
     */
    public static ProjectFile getInformation(String projectId,String fileName, String path){

        ProjectFile projectFile = new ProjectFile();

        projectFile.setProjectId(projectId);

        projectFile.setType(0);

        projectFile.setProjectFileId(UUID.randomUUID().toString());

        projectFile.setDate(LocalDateTime.now());

        projectFile.setName(fileName);

        projectFile.setPath(path);

        return projectFile;

    }

}
