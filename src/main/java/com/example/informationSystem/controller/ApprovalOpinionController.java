package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ApprovalOpinion;
import com.example.informationSystem.service.ApprovalOpinionService;
import com.example.informationSystem.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 15:12
 */
@RestController
@Api(tags = "审批意见")
public class ApprovalOpinionController {

    @Autowired
    private ApprovalOpinionService approvalOpinionService;

    @ApiOperation(value = "用户——插入审批意见")
    @PostMapping("/Build/ApprovalOpinion/Insert")
    public Result addApprovalOpinion(ApprovalOpinion approvalOpinion){

        if(approvalOpinionService.addApprovalOpinion(approvalOpinion)){

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }


    @ApiOperation(value = "用户——查询审批意见")
    @GetMapping("/Build/ApprovalOpinion/User/Id/Info")
    public Result selectApprovalOpinionByUserIdAndProjectId(String userId,String projectId){

        return Result.success("查询成功",approvalOpinionService.selectApprovalOpinionByUserIdAndProjectId(userId,projectId));

    }

}
