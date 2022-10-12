package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.DTO.ProjectInspectionDTO;
import com.example.informationSystem.entity.ProjectInspection;
import com.example.informationSystem.entity.VO.ProjectInspectionVO;

import java.util.List;

/**
 * @author pcdn
 */
public interface ProjectInspectionService {

    /**
     * 增加项目验收计划
     * @param projectInspectionVO 项目验收VO对象
     * @param userId 用户id
     * @return 是否增加成功
     */
    boolean addProjectInspection(ProjectInspectionVO projectInspectionVO,String userId);

    /**
     * 根据用户id分页查询某个状态的项目验收
     * @param userId 用户id
     * @param current 当前页
     * @param size 页大小
     * @param status 项目状态
     * @return 分页
     */
    IPage<ProjectInspectionDTO> selectProjectInspectionByUserIdAndStatus(String userId,long current, long size, Integer status);

    /**
     * 根据用户id分页查询项目验收
     * @param userId 用户id
     * @param currentPage 当前页
     * @param pageSize 页大小
     * @return 分页
     */
    IPage<ProjectInspectionDTO> selectProjectInspectionByUserId(String userId, long currentPage, long pageSize);

    /**
     * 通过单位id和状态获取未审核链表
     * @param unitId 单位id
     * @param status 状态
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 数据
     */
    IPage<ProjectInspectionDTO> selectProjectInspectionByUnitIdAndStatus(String unitId,int status, long currentPage, long pageSize);


    /**
     * 设置审批意见
     * @param projectInspectionId 项目验收id
     * @param userId 用户id
     * @param approvalOpinionContext 审批内容
     * @return 是否成功
     */
    boolean setApprovalOpinion(String projectInspectionId,String userId, String approvalOpinionContext);

    /**
     * 通过单位id和状态获取未审核链表
     * @param status 状态
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 数据
     */
    IPage<ProjectInspectionDTO> selectProjectInspectionByStatus(int status, long currentPage, long pageSize);
    /**
     * 更新项目验收报告状态
     * @param status 状态
     * @param projectInspectionId 项目验收id
     * @return 结果
     */
    boolean updateProjectInspectionStatus(String projectInspectionId, Integer status);


    /**
     * 更新项目验收报告
     * @param pathList 文件数组
     * @param projectId 项目验收信息
     * @return  是否成功
     */
    boolean updateProjectInspection(String projectId,List<String> pathList);

    /**
     * 批量删除预算验收
     * @param projectInspectionIdList 验收id
     * @return 结果
     */
    boolean deleteProjectInspection(List<String> projectInspectionIdList);

    /**
     * 删除预算验收
     * @param projectInspectionId 验收表id
     * @return 结果
     */
    boolean deleteProjectInspection(String projectInspectionId);

    /**
     * 通过项目id获取项目负责人
     * @param projectId 项目id
     * @return 项目负责人id
     */
    String getUserIdByProjectId(String projectId);

    /**
     * 通过项目id查询是否存在项目验收报告
     * @param projectId 项目id
     * @return 是否成功
     */
    boolean isExistProjectInspectionByProjectId(String projectId);


    /**
     * 通过id获取项目负责人
     * @param projectInspectionId 项目验收id
     * @return 项目负责人id
     */
    String getUserIdById(String projectInspectionId);

    /**
     * 通过id获取指定项目验收内容
     * @param projectInspectionId 项目验收id
     * @return 项目验收对象
     */
    ProjectInspection selectProjectInspectionById(String projectInspectionId);
}
