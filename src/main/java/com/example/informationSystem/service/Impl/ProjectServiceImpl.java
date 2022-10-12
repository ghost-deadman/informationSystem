package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.informationSystem.entity.*;
import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.VO.ProjectUnitVO;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.mapper.*;
import com.example.informationSystem.service.ProjectProcessService;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.GetStatusString;
import com.example.informationSystem.utils.Pager;
import com.example.informationSystem.utils.Result;
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

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private ProjectProcessService projectProcessService;


    @Override
    public boolean addProject(ProjectVO projectVO, List<String> pathList) {

        projectVO.setProjectId(String.valueOf(UUID.randomUUID()));

        projectVO.setCreateDate(LocalDateTime.now());

        addSubjectListData(projectVO.getSubjectIdList(),projectVO.getProjectId());

        addProjectFileListData(pathList,projectVO.getProjectId());

        projectProcessService.addProjectProcess(projectVO.getProjectId(),GetStatusString.getCreateProjectStatus(0));
        //更新草稿数据
        projectMapper.insert(projectVO);

        return true;

    }

    @Override
    public Result projectUnitAnalysis() {
        /*
        对项目中的单位进行分析
        1.首先查询所有单位表内的单位名称
        2.然后查询对应项目对象单位的数量
        3.将单位名称和数量一起封装返回
         */
        List<Unit> unitList = unitMapper.selectList(null);
        List<ProjectUnitVO> projectUnitVOList = new ArrayList<>();
        for(Unit unit :unitList){
            int count = projectMapper.selectProjectUnitCount(unit.getName());
            if(count == 0){
                continue;
            }
            projectUnitVOList.add(new ProjectUnitVO(unit.getName(),count));
        }
        return Result.success("200",projectUnitVOList);
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

        String status = GetStatusString.getCreateProjectStatus(createStatus);

        projectProcessService.addProjectProcess(projectId,status);

        return true;

    }

    @Override
    public boolean updateProjectExecuteStatusById(String projectId, int executeStatus) {

        UpdateWrapper<Project> projectUpdateWrapper = new UpdateWrapper<>();

        projectUpdateWrapper.eq("project_id",projectId);

        projectUpdateWrapper.set("execute_status",executeStatus);

        projectMapper.update(null,projectUpdateWrapper);

        projectProcessService.addProjectProcess(projectId,GetStatusString.getExecuteProjectStatus(executeStatus));

        return true;
    }

    @Override
    public boolean updateProjectCreateStatusToStartByIdList(List<String> projectIdList) {

        for (String projectId : projectIdList) {

            projectMapper.updateProjectCreateStatusToStartById(projectId);

            projectProcessService.addProjectProcess(projectId,GetStatusString.getCreateProjectStatus(-1));

        }

        return true;

    }

    public List<ProjectDTO> projectDtoSetSubjectData(List<ProjectDTO> projectDtoList){

        List<ProjectDTO> projectDTOList = new ArrayList<>();

        for(ProjectDTO projectDTO : projectDtoList){

            projectDTO = projectDtoSetSubjectData(projectDTO);

            projectDTOList.add(projectDTO);

        }

        return projectDTOList;

    }

    public ProjectDTO projectDtoSetSubjectData(ProjectDTO projectDTO){

            List<Subject> subjectList = new ArrayList<>();

            QueryWrapper<ProjectSubject> projectSubjectQueryWrapper = new QueryWrapper<>();

            projectSubjectQueryWrapper.eq("project_id",projectDTO.getProjectId());

            List<ProjectSubject> subjectIdList = projectSubjectMapper.selectList(projectSubjectQueryWrapper);

            for (ProjectSubject subjectId : subjectIdList) {

               QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();

                subjectQueryWrapper.eq("subject_id", subjectId.getSubjectId());

                subjectList.add(subjectMapper.selectOne(subjectQueryWrapper));

            }

            projectDTO.setSubjectList(subjectList);

            return projectDTO;

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

    /**
     * 通过项目id查询项目扩展对象
     *
     * @param projectId 项目id
     * @return 项目扩展对象
     */
    @Override
    public ProjectDTO selectProjectDtoByProjectId(String projectId) {

        ProjectDTO projectDto = projectMapper.selectProjectByProjectId(projectId);

        return  projectDtoSetSubjectData(projectDto);

    }


}
