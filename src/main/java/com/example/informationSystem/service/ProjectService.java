package com.example.informationSystem.service;

import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.VO.ProjectVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectService {

    /**
     * 添加项目
     * @param projectVO 项目扩展对象
     * @param pathList 项目文件路径
     * @return 是否成功
     */
    boolean addProject(ProjectVO projectVO, String pathList);

    /**
     * 添加项目
     * @param project 项目对象
     * @return 是否成功
     */
    boolean addProject(Project project);

    /**
     * 更新项目
     * @param project 项目对象
     * @return 是否成功
     */
    boolean updateProject(Project project);

    /**
     * 删除项目
     * @param id 项目id
     * @return 是否成功
     */
    boolean deleteProjectById(String id);

    /**
     * 查询指定项目
     * @param id 项目主键
     * @return 项目对象
     */
    Project selectProjectById(String id);

    /**
     * 按项目负责人id查询项目
     * @param userId 项目负责人id
     * @return 项目数组
     */
    List<Project> selectProjectByUserId(String userId);

}
