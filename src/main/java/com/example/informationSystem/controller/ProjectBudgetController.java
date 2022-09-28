package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.VO.ProjectBudgetVO;
import com.example.informationSystem.entity.dto.ProjectBudgetDTO;
import com.example.informationSystem.service.ProjectBudgetService;
import com.example.informationSystem.utils.Result;
import com.example.informationSystem.utils.TestVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
    @RequestMapping("/Build/ProjectBudget/addProjectBudget/save")
    public Result saveProjectBudget(@RequestBody ProjectBudgetVO projectBudgetVO) throws ParseException {
        return projectBudgetService.addProjectBudget(projectBudgetVO, 0);
    }

    /**
     * 保存并提交预算
     * @param projectBudgetVO 项目预算
     * @return Result对象，判断是否增加成功
     */
    @PostMapping("/Build/ProjectBudget/addProjectBudget/saveAndSubmit")
    public Result saveAndSubmitProjectBudget(@RequestBody ProjectBudgetVO projectBudgetVO) throws ParseException {
        return projectBudgetService.addProjectBudget(projectBudgetVO, 1);
    }

    /**
     * 提交预算
     * @param pbId 项目预算id
     * @return Result对象，判断是否增加成功
     */
    @GetMapping("/Build/ProjectBudget/Project/submit")
    public Result submitProjectBudget(@Param("pbId") String pbId ) throws ParseException {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 1);
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
    @GetMapping("/Build/ProjectBudget/Principal/pass")
    public Result passProjectBudget(@Param("pbId") String pbId ) throws ParseException {
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
    @GetMapping("/Build/ProjectBudget/Principal/unPass")
    public Result unPassProjectBudget(@Param("pbId") String pbId ) throws ParseException {
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
    @GetMapping("/Cent/ProjectBudget/Admin/Pass")
    public Result PassProjectBudget1(@Param("pbId") String pbId ) {
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
    @GetMapping("/Cent/ProjectBudget/Admin/unPass")
    public Result FaithProjectBudget1(@Param("pbId") String pbId ){
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
    @GetMapping("/Over/ProjectBudget/Admin/Pass")
    public Result PassProjectBudget2(@Param("pbId") String pbId ) throws ParseException {
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
    @GetMapping("/Over/ProjectBudget/Admin/unPass")
    public Result FaithProjectBudget2(@Param("pbId") String pbId ) throws ParseException {
        boolean b = projectBudgetService.checkProjectBudget(pbId, 7);
        if (b) {
            return Result.success("提交成功");
        }else {
            return Result.error("提交失败，请重试");
        }
    }


    /**
     * 项目负责人查看自己的预算申请列表
     * @param status 状态 0 1 2 3 4 5 6 7
     * @param current 当前页
     * @param size 大小
     * @return 结果
     */
    @GetMapping("/Build/ProjectBudget/Project/status")
    public Result searchProjectBudgetsOfProject(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {
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
    @GetMapping("/Build/ProjectBudget/Admin/status")
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

    @GetMapping("/Cent/ProjectBudget/Admin/status")
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
    @GetMapping("/Over/ProjectBudget/Pass")
    public Result searchProjectBudgetPass(@Param("status") Integer status, @Param("current") Integer current, @Param("size") Integer size) {
        Page<ProjectBudgetDTO> page = projectBudgetService.selectAllPages(current, size, status);
        if (page != null) {
            return Result.success("查询成功", page);
        } else {
            return Result.error("查询失败");
        }
    }

}
