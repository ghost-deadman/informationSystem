package com.example.informationSystem.controller;

import com.example.informationSystem.entity.DTO.ArrangePlanDTO;
import com.example.informationSystem.entity.VO.ArrangePlanVO;
import com.example.informationSystem.service.ArrangePlanService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pcdn
 */
@RestController
@RequestMapping("/api/v1/arrangePlan")
public class ArrangePlanController {

    @Autowired
    private ArrangePlanService arrangePlanService;

    /**
     * 添加
     * @param arrangePlanVO vo
     * @return 结果
     */
    @PostMapping("/Build/ArrangePlan/User/Insert")
    public Result insertPlan(@RequestBody ArrangePlanVO arrangePlanVO) {
        return arrangePlanService.insertPlan(arrangePlanVO);

    }

    @GetMapping("/Build/ArrangePlan/User/List")
    public Result userSelectById(String planId) {
        List<ArrangePlanDTO> listByProjectId = arrangePlanService.getListByProjectId(planId);
        if (listByProjectId == null) {
            return Result.error("查询失败！");
        }else {
            return Result.success("查询成功！", listByProjectId);
        }
    }

    @GetMapping("/Centralized/ArrangePlan/Admin/List")
    public Result adminSelectById(String planId) {
        List<ArrangePlanDTO> listByProjectId = arrangePlanService.getListByProjectId(planId);
        if (listByProjectId == null) {
            return Result.error("查询失败！");
        }else {
            return Result.success("查询成功！", listByProjectId);
        }
    }


}
