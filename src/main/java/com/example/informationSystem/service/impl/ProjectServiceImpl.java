package com.example.informationSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.mapper.ProjectMapper;
import com.example.informationSystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

//    @Autowired
//    private ProjectFileMapper projectFileMapper;

//    @Autowired
//    private ProjectSubjectMapper projectSubjectMapper;

    @Override
    public boolean addProject(ProjectVO projectVO,String pathList){

        boolean result;

        String projectId = String.valueOf(UUID.randomUUID());

        String projectDraftId = String.valueOf(UUID.randomUUID());

        /*
         *新建项目草稿
         */
        ProjectDraft projectDraft = new ProjectDraft();

        projectDraft.setProjectId(projectId);

        //projectDraft.setProjectCategoryId(projectVO.getProjectCategoryId());

        projectDraft.setName(projectVO.getName());

        projectDraft.setDescribes(projectVO.getDescribes());

        projectDraft.setType(projectVO.getType());

        projectDraft.setProjectUserId(projectVO.getProjectUserId());

        projectDraft.setUnitId(projectVO.getUnitId());

        projectDraft.setCreateDate(LocalDateTime.now());


        /*
         * 新建项目
         */
        Project project = new Project();

        project.setProjectId(projectId);

        result = addProject(project);

//        if(result) {
//
//                /*
//                 *新建项目文件
//                 */
//
//
//                String fileName = pathList.substring(pathList.lastIndexOf("\\") + 1);
//
//                ProjectFile projectFile = getInformation(projectId, projectDraftId, fileName, pathList);
//
//                projectFileMapper.insert(projectFile);
//
//                /*
//                 *添加项目学科关联
//                 */
//                 List<String> subjectIdList = projectVO.getSubjectIdList();
//
//                 for(String subjectId : subjectIdList) {
//
//                     ProjectSubject projectSubject = new ProjectSubject();
//
//                     projectSubject.setProjectSubjectId(String.valueOf(UUID.randomUUID()));
//
//                     projectSubject.setProjectId(projectId);
//
//                     projectSubject.setProjectDraftId(projectDraftId);
//
//                     projectSubject.setProjectSubjectId(subjectId);
//
//                     projectSubjectMapper.insert(projectSubject);
//                 }
//
//                return true;
//
//        }
//
        return false;

    }

    @Override
    public boolean addProject(Project project) {

        projectMapper.insert(project);

        return true;

    }

    @Override
    public boolean updateProject(Project project) {

        projectMapper.updateById(project);

        return true;

    }

    @Override
    public boolean deleteProjectById(String id) {

        projectMapper.deleteById(id);

        return true;

    }

    @Override
    public Project selectProjectById(String id) {

        return projectMapper.selectById(id);

    }



    @Override
    public List<Project> selectProjectByUserId(String userId) {

        QueryWrapper<Project> projectQueryWrapper = new QueryWrapper<>();

        projectQueryWrapper.eq("project_user_id",userId);

        return projectMapper.selectList(projectQueryWrapper);

    }

//    /**
//     * 获取文件相关信息存储项目文件对象中
//     * @param fileName 文件名称
//     * @return 项目文件对象
//     */
//    public ProjectFile getInformation(String projectId,String projectDraftId,String fileName, String path){
//
//        ProjectFile projectFile = new ProjectFile();
//
//        projectFile.setProjectId(projectId);
//
//        projectFile.setProjectDraftId(projectDraftId);
//
//        projectFile.setType(0);
//
//        projectFile.setProjectFileId(UUID.randomUUID().toString());
//
//        projectFile.setDate(LocalDateTime.now());
//
//        projectFile.setName(fileName);
//
//        projectFile.setPath(path);
//
//        return projectFile;
//
//    }


}
