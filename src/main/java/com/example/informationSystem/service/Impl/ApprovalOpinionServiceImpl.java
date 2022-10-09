package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.mapper.ApprovalOpinionMapper;
import com.example.informationSystem.service.ApprovalOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 15:09
 */
@Service
public class ApprovalOpinionServiceImpl implements ApprovalOpinionService {

    @Autowired
    private ApprovalOpinionMapper approvalOpinionMapper;

    @Override
    public boolean addApprovalOpinion(ApprovalOpinion approvalOpinion) {

        approvalOpinionMapper.insert(approvalOpinion);

        return true;

    }

    @Override
    public boolean deleteApprovalOpinionById(String id) {

        approvalOpinionMapper.deleteById(id);

        return true;

    }

    @Override
    public boolean updateApprovalOpinionById(ApprovalOpinion approvalOpinion) {

        approvalOpinionMapper.updateById(approvalOpinion);

        return true;

    }

    @Override
    public ApprovalOpinion selectApprovalOpinionById(String id) {

        return approvalOpinionMapper.selectById(id);

    }

    @Override
    public ApprovalOpinion selectApprovalOpinionByUserIdAndProjectId(String userId, String projectId) {

        QueryWrapper<ApprovalOpinion> approvalOpinionQueryWrapper = new QueryWrapper<>();

        approvalOpinionQueryWrapper.eq("user_id",userId);

        approvalOpinionQueryWrapper.eq("project_id",projectId);

        return approvalOpinionMapper.selectOne(approvalOpinionQueryWrapper);

    }
}
