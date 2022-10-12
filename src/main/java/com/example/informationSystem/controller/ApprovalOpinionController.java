package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.service.ApprovalOpinionService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 15:12
 */
@RestController
public class ApprovalOpinionController {

    @Autowired
    private ApprovalOpinionService approvalOpinionService;

    @RequestMapping("/Build/ApprovalOpinion/Insert")
    public Result addApprovalOpinion(ApprovalOpinion approvalOpinion){

        if(approvalOpinionService.addApprovalOpinion(approvalOpinion)){

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }



    @RequestMapping("/Build/ApprovalOpinion/User/Id/Info")
    public Result selectApprovalOpinionByUserIdAndProjectId(String userId,String projectId){

        return Result.success("查询成功",approvalOpinionService.selectApprovalOpinionByUserIdAndProjectId(userId,projectId));

    }

}
