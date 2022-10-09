package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.entity.DTO.ProjectInspectionDTO;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.entity.ProjectInspection;
import com.example.informationSystem.entity.VO.ProjectInspectionVO;
import com.example.informationSystem.mapper.ApprovalOpinionMapper;
import com.example.informationSystem.mapper.ProjectFileMapper;
import com.example.informationSystem.mapper.ProjectInspectionMapper;
import com.example.informationSystem.service.ProjectInspectionService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author pcdn
 */
@Service
public class ProjectInspectionServiceImpl implements ProjectInspectionService {


    @Autowired
    private ApprovalOpinionMapper approvalOpinionMapper;

    @Autowired
    private ProjectInspectionMapper projectInspectionMapper;

    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Override
    public boolean addProjectInspection(ProjectInspectionVO projectInspectionVO,String userId) {

        ProjectInspection projectInspection = new ProjectInspection();

        projectInspection.setProjectInspectionId(String.valueOf(UUID.randomUUID()));

        projectInspection.setProjectId(projectInspectionVO.getProjectId());

        projectInspection.setType(0);

        projectInspection.setUserId(userId);

        projectInspection.setCreateDate(LocalDateTime.now());

        projectInspectionMapper.insert(projectInspection);

        return true;

    }

    @Override
    public IPage<ProjectInspectionDTO> selectProjectInspectionByUserIdAndStatus(String userId,long current, long size, Integer status) {

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = new Page<>(current,size);

        QueryWrapper<ProjectInspection> projectInspectionQueryWrapper = new QueryWrapper<>();

        projectInspectionQueryWrapper.eq("status",status);

        List<ProjectInspectionDTO> projectInspectionDtoList = projectInspectionMapper.selectByUserAndStatusIdPage(projectInspectionDtoPage.offset(),size,userId,status);

        projectInspectionDtoPage.setRecords(projectInspectionDtoList);

        return projectInspectionDtoPage;

    }

    @Override
    public IPage<ProjectInspectionDTO> selectProjectInspectionByUserId(String userId, long currentPage, long pageSize) {
        return null;
    }

    @Override
    public boolean updateProjectInspectionStatus(String projectInspectionId, Integer status) {

        UpdateWrapper<ProjectInspection> projectInspectionUpdateWrapper = new UpdateWrapper<>();

        projectInspectionUpdateWrapper.eq("project_inspection_id",projectInspectionId);

        projectInspectionUpdateWrapper.set("status",status);

        projectInspectionMapper.update(null,projectInspectionUpdateWrapper);

        return true;

    }

    @Override
    public boolean updateProjectInspection(String projectId, List<String> pathList) {

        int fileType = 6;

        //文件放入
        for (String path : pathList) {

            String fileName = path.substring(path.lastIndexOf("\\") + 1);

            QueryWrapper<ProjectFile> projectFileQueryWrapper = new QueryWrapper<>();

            projectFileQueryWrapper.eq("type",fileType);

            projectFileQueryWrapper.eq("project_id",projectId);

            ProjectFile projectFile = projectFileMapper.selectOne(projectFileQueryWrapper);

            //依次更新年度验收报告 中期验收报告 完结验收报告三个文件
            fileType++;

            projectFile.setDate(LocalDateTime.now());

            projectFile.setPath(path);

            projectFile.setName(fileName);

            projectFileMapper.updateById(projectFile);

        }

        return true;

    }

    @Override
    public boolean deleteProjectInspection(List<String> projectInspectionIdList) {

        projectInspectionMapper.deleteBatchIds(projectInspectionIdList);

        return true;

    }

    @Override
    public boolean deleteProjectInspection(String projectInspectionId) {

        projectInspectionMapper.deleteById(projectInspectionId);

        return true;

    }

    @Override
    public String getUserIdByProjectId(String projectId) {
       return projectInspectionMapper.getUserIdByProject(projectId);
    }

    @Override
    public boolean isExistProjectInspectionByProjectId(String projectId) {

        QueryWrapper<ProjectInspection> projectInspectionQueryWrapper = new QueryWrapper<>();

        projectInspectionQueryWrapper.eq("project_id",projectId);

        return projectInspectionMapper.selectCount(projectInspectionQueryWrapper) > 0;
    }

    @Override
    public String getUserIdById(String projectInspectionId) {
        return projectInspectionMapper.getUserIdById(projectInspectionId);
    }

    @Override
    public ProjectInspection selectProjectInspectionById(String projectInspectionId) {
        return projectInspectionMapper.selectById(projectInspectionId);
    }

    @Override
    public IPage<ProjectInspectionDTO> selectProjectInspectionByUnitIdAndStatus(String unitId,int status, long currentPage, long pageSize) {

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = new Page<>(currentPage,pageSize);

        List<ProjectInspectionDTO> projectInspectionDtoList = projectInspectionMapper.selectByUnitIdAndStatusPage(projectInspectionDtoPage.offset(),pageSize,unitId,status);

        projectInspectionDtoPage.setRecords(projectInspectionDtoList);

        return projectInspectionDtoPage;


    }

    @Override
    public boolean setApprovalOpinion(String projectInspectionId,String userId, String approvalOpinionContext) {

        ProjectInspection projectInspection = projectInspectionMapper.selectById(projectInspectionId);

        ApprovalOpinion approvalOpinion = new ApprovalOpinion();

        approvalOpinion.setApprovalOpinionId(String.valueOf(UUID.randomUUID()));

        approvalOpinion.setContext(approvalOpinionContext);

        approvalOpinion.setProjectId(projectInspection.getProjectId());

        approvalOpinion.setDate(LocalDateTime.now());

        approvalOpinion.setUserId(userId);

        projectInspection.setApprovalOpinionId(approvalOpinion.getApprovalOpinionId());

        approvalOpinionMapper.insert(approvalOpinion);

        projectInspectionMapper.updateById(projectInspection);

        return true;

    }

    @Override
    public IPage<ProjectInspectionDTO> selectProjectInspectionByStatus(int status, long currentPage, long pageSize) {

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = new Page<>(currentPage,pageSize);

        List<ProjectInspectionDTO> projectInspectionDtoList = projectInspectionMapper.selectByStatusPage(projectInspectionDtoPage.offset(),pageSize,status);

        projectInspectionDtoPage.setRecords(projectInspectionDtoList);

        return projectInspectionDtoPage;


    }

}
