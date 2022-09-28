package com.example.informationSystem.service;

import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.utils.Pager;

import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectService {

    /**
     * 添加项目
     * @param projectVO 项目扩展对象
     * @param pathList 项目文件数组路径
     * @return 是否成功
     */
    boolean addProject(ProjectVO projectVO, List<String> pathList);

    /**
     * 删除项目
     * @param projectIdList 项目id数组
     * @return 是否成功
     */
    boolean deleteProjectById(List<String> projectIdList);

    /**
     * 分页按项目负责人id项目扩展对象
     * @param createStatus 项目状态
     * @param userId 项目负责人id
     * @param page 页数
     * @param size 每页数据条数
     * @return 数据
     */
    Pager<ProjectDTO> selectProjectDtoByUserId(int createStatus,String userId, long page, long size);

    /**
     * 更新项目
     * @param projectVO 项目扩展对象
     * @param pathList 文件路径数组
     * @return 是否成功
     */
    boolean updateProject(ProjectVO projectVO, List<String> pathList);

    /**
     * 更新项目
     * @param projectVO 项目扩展对象
     * @return 是否成功
     */
    boolean updateProject(ProjectVO projectVO);

    /**
     * 更新项目创建状态
     * @param projectId 项目id
     * @param createStatus 状态
     * @return 是否成功
     */
    boolean updateProjectCreateStatusById(String projectId, int createStatus);

    /**
     * 通过单位和创建状态查询项目扩展类
     * @param createStatus 创建状态
     * @param unitId 单位id
     * @param currentPage 第几页
     * @param pageSize 每页数据条数
     * @return 项目扩展对象
     */
    Pager<ProjectDTO> selectProjectDtoByUnitAndCreateStatus(int createStatus, String unitId, long currentPage, long pageSize);

    /**
     * 给指定项目添加审批意见
     * @param projectId 项目id
     * @param userId 意见填写人
     * @param approvalOpinionContext 审批意见内容
     * @return 是否成功
     */
    boolean setApprovalOpinion(String projectId,String userId,String approvalOpinionContext);

    /**
     * 按状态查询项目扩展对象
     * @param createStatus 创建状态
     * @param currentPage  页数
     * @param pageSize 每页数据条数
     * @return 项目扩展对象
     */
    Pager<ProjectDTO> selectProjectDtoByCreateStatusPage(int createStatus, long currentPage, long pageSize);
}
