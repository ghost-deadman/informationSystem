package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.informationSystem.entity.*;
import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.mapper.*;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 9:47
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Autowired
    private ProjectSubjectMapper projectSubjectMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private ApprovalOpinionMapper approvalOpinionMapper;


    @Override
    public boolean addProject(ProjectVO projectVO, List<String> pathList) {

        projectVO.setProjectId(String.valueOf(UUID.randomUUID()));

        projectVO.setCreateDate(LocalDateTime.now());

        addSubjectListData(projectVO.getSubjectIdList(),projectVO.getProjectId());

        addProjectFileListData(pathList,projectVO.getProjectId());

        //更新草稿数据
        projectMapper.insert(projectVO);

        return true;

    }

    public void  addSubjectListData(List<String> subjectList,String projectId){

        //文件放入
        for (String subjectId : subjectList) {

            ProjectSubject projectSubject = new ProjectSubject();

            projectSubject.setProjectId(projectId);

            projectSubject.setSubjectId(subjectId);

            projectSubjectMapper.insert(projectSubject);

        }

    }

    public void  addProjectFileListData(List<String> pathList,String projectId){

        //文件放入
        for (String path : pathList) {

            String fileName = path.substring(path.lastIndexOf("\\") + 1);

            ProjectFile projectFile = ProjectFileServiceImpl.getInformation(projectId, fileName, path,0);

            projectFileMapper.insert(projectFile);

        }

    }


    @Override
    public boolean deleteProjectById(List<String> projectIdList) {

        projectMapper.deleteBatchIds(projectIdList);

        return true;

    }


    @Override
    public Pager<ProjectDTO> selectProjectDtoByUserIdAndCreateStatus(int createStatus, String userId, long page, long size) {

        Pager<ProjectDTO> projectDtoPager = new Pager<>(page, size);

        List<ProjectDTO> projectDtoList = projectMapper.selectProjectByCreateStatusAndUserPage(createStatus, userId, projectDtoPager.getOffset(), size);

        projectDtoList = projectDtoSetSubjectData(projectDtoList);

        projectDtoPager.setDataList(projectDtoList);

        return projectDtoPager;
    }

    @Override
    public Pager<ProjectDTO> selectProjectDtoByUserIdAndExecuteStatus(int executeStatus, String userId, long page, long size) {

        Pager<ProjectDTO> projectDtoPager = new Pager<>(page, size);

        List<ProjectDTO> projectDtoList = projectMapper.selectProjectByExecuteStatusAndUserPage(executeStatus, userId, projectDtoPager.getOffset(), size);

        projectDtoList = projectDtoSetSubjectData(projectDtoList);

        projectDtoPager.setDataList(projectDtoList);

        return projectDtoPager;
    }

    @Override
    public Pager<ProjectDTO> selectProjectDtoByUserId(String userId, long page, long size) {

        Pager<ProjectDTO> projectDtoPager = new Pager<>(page, size);

        List<ProjectDTO> projectDtoList = projectMapper.selectProjectByUserPage(userId, projectDtoPager.getOffset(), size);

        projectDtoList = projectDtoSetSubjectData(projectDtoList);

        projectDtoPager.setDataList(projectDtoList);

        return projectDtoPager;
    }

    @Override
    public boolean updateProject(ProjectVO projectVO, List<String> pathList) {

        //有文件要更新文件
        QueryWrapper<ProjectFile> projectFileQueryWrapper = new QueryWrapper<>();

        projectFileQueryWrapper.eq("project_id", projectVO.getProjectId());

        //删除文件 重新添加
        projectFileMapper.delete(projectFileQueryWrapper);

        QueryWrapper<ProjectSubject> projectSubjectQueryWrapper = new QueryWrapper<>();

        projectSubjectQueryWrapper.eq("project_id", projectVO.getProjectId());

        projectSubjectMapper.delete(projectSubjectQueryWrapper);

        addSubjectListData(projectVO.getSubjectIdList(),projectVO.getProjectId());

        addProjectFileListData(pathList,projectVO.getProjectId());

        //更新草稿数据
        projectMapper.updateById(projectVO);

        return true;

    }

    @Override
    public boolean updateProject(ProjectVO projectVO) {

        projectMapper.updateById(projectVO);

        return true;

    }

    @Override
    public boolean updateProjectCreateStatusById(String projectId, int createStatus) {

        UpdateWrapper<Project> projectUpdateWrapper = new UpdateWrapper<>();

        projectUpdateWrapper.eq("project_id",projectId);

        projectUpdateWrapper.set("create_status",createStatus);

        projectMapper.update(null,projectUpdateWrapper);

        return true;

    }

    @Override
    public boolean updateProjectExecuteStatusById(String projectId, int executeStatus) {

        UpdateWrapper<Project> projectUpdateWrapper = new UpdateWrapper<>();

        projectUpdateWrapper.eq("project_id",projectId);

        projectUpdateWrapper.set("execute_status",executeStatus);

        projectMapper.update(null,projectUpdateWrapper);

        return true;
    }

    @Override
    public boolean updateProjectCreateStatusToStartByIdList(List<String> projectIdList) {

        for (String projectId : projectIdList) {

            projectMapper.updateProjectCreateStatusToStartById(projectId);

        }

        return true;

    }

    public List<ProjectDTO> projectDtoSetSubjectData(List<ProjectDTO> projectDtoList){

        List<Subject> subjectList = new ArrayList<>();

        for(ProjectDTO projectDTO : projectDtoList){

            QueryWrapper<ProjectSubject> projectSubjectQueryWrapper = new QueryWrapper<>();

            projectSubjectQueryWrapper.eq("project_id",projectDTO.getProjectId());

            List<ProjectSubject> subjectIdList = projectSubjectMapper.selectList(projectSubjectQueryWrapper);

            for (ProjectSubject subjectId : subjectIdList) {

                QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();

                subjectQueryWrapper.eq("subject_id", subjectId.getSubjectId());

                subjectList.add(subjectMapper.selectOne(subjectQueryWrapper));

            }

            projectDTO.setSubjectList(subjectList);

        }

        return projectDtoList;

    }

    @Override
    public Pager<ProjectDTO> selectProjectDtoByUnitAndCreateStatus(int createStatus, String unitId, long currentPage, long pageSize) {

        Pager<ProjectDTO> projectDtoPager = new Pager<>(createStatus, pageSize);

        List<ProjectDTO> projectDtoList = projectMapper.selectProjectByCreateStatusAndUnitPage(createStatus, unitId, projectDtoPager.getOffset(), pageSize);

        projectDtoList = projectDtoSetSubjectData(projectDtoList);

        projectDtoPager.setDataList(projectDtoList);

        return projectDtoPager;


    }

    @Override
    public boolean setApprovalOpinion(String projectId,String userId, String approvalOpinionContext) {

        ApprovalOpinion approvalOpinion = new ApprovalOpinion();

        approvalOpinion.setApprovalOpinionId(String.valueOf(UUID.randomUUID()));

        approvalOpinion.setContext(approvalOpinionContext);

        approvalOpinion.setProjectId(projectId);

        approvalOpinion.setDate(LocalDateTime.now());

        approvalOpinion.setUserId(userId);

        Project project = projectMapper.selectById(projectId);

        project.setApprovalOpinionId(approvalOpinion.getApprovalOpinionId());

        approvalOpinionMapper.insert(approvalOpinion);

        projectMapper.updateById(project);

        return true;

    }

    @Override
    public Pager<ProjectDTO> selectProjectDtoByCreateStatusPage(int createStatus, long currentPage, long pageSize) {

        Pager<ProjectDTO> projectDtoPager = new Pager<>(currentPage,pageSize);

        List<ProjectDTO> projectDtoList =  projectMapper.selectProjectByCreateStatusPage(createStatus,projectDtoPager.getOffset(),pageSize);

        for (ProjectDTO projectDTO : projectDtoList){

            ApprovalOpinion approvalOpinion = approvalOpinionMapper.selectById(projectDTO.getApprovalOpinionId());

            projectDTO.setApprovalOpinion(approvalOpinion);

        }

        projectDtoSetSubjectData(projectDtoList);

        projectDtoPager.setDataList(projectDtoList);

        return projectDtoPager;

    }

    @Override
    public String getProjectUserIdByProjectId(String projectId) {

        Project project = projectMapper.selectById(projectId);

        return project.getProjectUserId();

    }


}
