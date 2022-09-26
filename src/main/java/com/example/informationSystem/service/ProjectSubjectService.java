package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectSubject;

import java.util.List;


public interface ProjectSubjectService {
    /**
     * 增加项目学科记录
     * @param projectSubject
     * @return
     */
    boolean addProjectSubject(ProjectSubject projectSubject);

    /**
     * 删除项目学科记录
     * @param id
     * @return
     */
    boolean deleteProjectSubject(String id);

    /**
     * 更新项目学科记录
     * @param projectSubject
     * @return
     */
    boolean updateProjectSubject(ProjectSubject projectSubject);

    /**
     * id查询项目学科记录
     * @param id
     * @return
     */
    ProjectSubject selectProjectSubjectById(String id);

    /**
     * 查询所有项目学科记录
     * @return
     */
    List<ProjectSubject> selectProjectSubject();

}
