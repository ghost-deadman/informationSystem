package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.ArrangePlanDTO;
import com.example.informationSystem.entity.VO.ArrangePlanVO;
import com.example.informationSystem.service.ArrangePlanService;
import com.example.informationSystem.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "预算使用日志")
public class ArrangePlanController {
    @Autowired
    private ArrangePlanService arrangePlanService;

    /**
     * 添加
     * @param arrangePlanVO vo
     * @return 结果
     */
    @ApiOperation(value = "用户——添加预算使用日志")
    @PostMapping("/build/ArrangePlan/User/Insert")
    public Result insertPlan(@RequestBody ArrangePlanVO arrangePlanVO) {
        return arrangePlanService.insertPlan(arrangePlanVO);

    }

    @ApiOperation(value = "用户——获取已填写日志")
    @GetMapping("/build/ArrangePlan/User/List")
    public Result userSelectById(Integer current, Integer size, String projectId) {
        Page<ArrangePlanDTO> listByProjectId = arrangePlanService.getListByProjectId(current, size, projectId);
        if (listByProjectId == null) {
            return Result.error("查询失败！");
        }else {
            return Result.success("查询成功！", listByProjectId);
        }
    }
    @ApiOperation(value = "归口部门——查看用户的项目日志")
    @GetMapping("/Centralized/ArrangePlan/Admin/List")
    public Result adminSelectById(Integer current, Integer size, String projectId) {
        Page<ArrangePlanDTO> listByProjectId = arrangePlanService.getListByProjectId(current, size,projectId);
        if (listByProjectId == null) {
            return Result.error("查询失败！");
        }else {
            return Result.success("查询成功！", listByProjectId);
        }
    }


}
