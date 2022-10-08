package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.ProjectBudgetDTO;
import com.example.informationSystem.entity.VO.ProjectBudgetVO;
import com.example.informationSystem.service.ProjectBudgetService;
import com.example.informationSystem.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pcdn
 */
@RestController

public class ProjectBudgetController {

    @Autowired
    private ProjectBudgetService projectBudgetService;

    /**
     * 增加项目预算
     *
     * @param projectBudgetVO 项目预算
     * @return Result对象，判断是否增加成功
     */
    @RequestMapping("/Build/ProjectBudget/Insert")
    public Result saveProjectBudget(ProjectBudgetVO projectBudgetVO) {

        return projectBudgetService.addProjectBudget(projectBudgetVO, 0);
    }

    /**
     * 保存并提交预算
     * @param projectBudgetVO 项目预算
     * @return Result对象，判断是否增加成功
     */
    @PostMapping("/Build/ProjectBudget/Submit/Insert")
    public Result saveAndSubmitProjectBudget(@RequestBody ProjectBudgetVO projectBudgetVO) {

        return projectBudgetService.addProjectBudget(projectBudgetVO, 1);

    }

    /**
     * 提交预算
     * @param projectBudgetId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/User/Submit/Update")
    public Result submitProjectBudget(String projectBudgetId ) {

        if (projectBudgetService.checkProjectBudget(projectBudgetId, 1)) {

            return Result.success("提交成功");

        }else {

            return Result.error("提交失败，请重试");

        }
    }


    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/PrincipalPass/Update")
    public Result passProjectBudget(@Param("pbId") String pbId ) {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 2);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/PrincipalUnPass/Update")
    public Result unPassProjectBudget(@Param("pbId") String pbId ) {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 3);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Centrailized/ProjectBudget/AdminPass/Update")
    public Result centralizedAdminPassProjectBudget(@Param("pbId") String pbId ) {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 4);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核未通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Centralized/ProjectBudget/AdminUnPass/Update")
    public Result centralizedAdminFailureProjectBudget(@Param("pbId") String pbId ){
        boolean b = projectBudgetService.checkProjectBudget(pbId, 5);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Overall/ProjectBudget/AdminPass/Update")
    public Result overallAdminPassProjectBudget(@Param("pbId") String pbId ) {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 6);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Logistics/ProjectBudget/PullMoney/Update")
    public Result logisticsPullMoneyProjectBudget(@Param("pbId") String pbId ) {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 7);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 审核通过预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Logistics/ProjectBudget/PullMoneyOver/Update")
    public Result logisticsPullMoneyOverProjectBudget(@Param("pbId") String pbId ) {

        boolean b = projectBudgetService.checkProjectBudget(pbId, 8);
        if (b) {

            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }

    /**
     * 建筑部门获取未审核项目预算数量
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/ProjectBudgetCount/User/Info")
    public Result projectUserGetProjectBudgetCount() {

        return Result.success("查询成功",projectBudgetService.getUndoByUserId(0));

    }

    /**
     * 建筑部门获取未审核项目预算数量
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/ProjectBudgetCount/Info")
    public Result principalGetProjectBudgetCount() {

        return Result.success("查询成功",projectBudgetService.getUndoByUnitId(1));

    }

    /**
     * 归口部门获取未审核项目预算数量
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Centralized/ProjectBudget/ProjectBudgetCount/Info")
    public Result centralizedGetProjectBudgetCount() {

        return Result.success("查询成功",projectBudgetService.getUndoCount(2));

    }

    /**
     * 总体部门获取未审核项目预算数量
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Overall/ProjectBudget/ProjectBudgetCount/Info")
    public Result overallGetProjectBudgetCount() {

        return Result.success("查询成功",projectBudgetService.getUndoCount(4));

    }

    /**
     * 后勤部门获取未审核项目预算数量
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Logistics/ProjectBudget/ProjectBudgetCount/Info")
    public Result logisticsGetProjectBudgetCount() {

        return Result.success("查询成功",projectBudgetService.getUndoCount(6));

    }

    /**
     * 项目负责人查看自己的预算申请列表
     * @param status 状态 0 1 2 3 4 5 6 7
     * @param current 当前页
     * @param size 大小
     * @return 结果
     */
    @GetMapping("/Build/ProjectBudget/User/Status")
    public Result searchProjectBudgetListByStatus(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {

        Page<ProjectBudgetDTO> page = projectBudgetService.selectOneStatusByUserId(current, size, status);

        if (page != null) {
            return Result.success("查询成功", page);
        } else {
            return Result.error("查询失败");
        }
    }

    /**
     * 单位负责人查看本单位的预算申请列表
     * @param status 状态 1 2 3
     * @param current 当前页
     * @param size 大小
     * @return 结果
     */
    @GetMapping("/Build/ProjectBudget/Principal/Status")
    public Result searchProjectBudgetsOfPrincipal(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {

        Page<ProjectBudgetDTO> page = projectBudgetService.selectOneStatusByUnitId(current, size, status);
        if (page != null) {
            return Result.success("查询成功", page);
        } else {
            return Result.error("查询失败");
        }
    }

    /**
     * 归口管理员查看自己的预算申请列表
     * @param status 状态 2 4 5
     * @param current 当前页
     * @param size 大小
     * @return 结果
     */

    @GetMapping("/Centralized/ProjectBudget/Admin/Status")
    public Result searchProjectBudgetsOfAdmin(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {

        Page<ProjectBudgetDTO> page = projectBudgetService.selectAllPages(current, size, status );

        if (page != null) {
            return Result.success("查询成功", page);
        } else {
            return Result.error("查询失败");
        }
    }

    /**
     * 总体协调管理员查看待支付的预算申请列表
     * @param status 状态 4 6 7
     * @param current 当前页
     * @param size 大小
     * @return 结果
     */
    @GetMapping("/Overall/ProjectBudget/Admin/Status")
    public Result searchProjectBudgetPass(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {
        Page<ProjectBudgetDTO> page = projectBudgetService.selectAllPages(current, size, status);
        if (page != null) {
            return Result.success("查询成功", page);
        } else {
            return Result.error("查询失败");
        }
    }



}
