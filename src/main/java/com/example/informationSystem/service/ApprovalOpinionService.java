package com.example.informationSystem.service;

import com.example.informationSystem.entity.ApprovalOpinion;

/**
 * @author pcdn
 */
public interface ApprovalOpinionService {

    /**
     * 添加审批意见
     * @param approvalOpinion 审批意见对象
     * @return 是否成功
     */
    boolean addApprovalOpinion(ApprovalOpinion approvalOpinion);

    /**
     * 删除审批意见
     * @param id 审批意见
     * @return 是否成功
     */
    boolean deleteApprovalOpinionById(String id);

    /**
     * 修改审批意见
     * @param approvalOpinion 审批意见
     * @return 是否成功
     */
    boolean updateApprovalOpinionById(ApprovalOpinion approvalOpinion);

    /**
     * 通过id查询审批
     * @param id 审批意见id
     * @return 审批意见对象
     */
    ApprovalOpinion selectApprovalOpinionById(String id);

    /**
     * 通过编写者和项目id查询审批意见
     * @param userId 编写者id
     * @param projectId 项目id
     * @return 审批意见对象
     */
    ApprovalOpinion selectApprovalOpinionByUserIdAndProjectId(String userId,String projectId);

}
