package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.informationSystem.entity.Acceptancelist;
import com.example.informationSystem.service.AcceptancelistService;
import com.example.informationSystem.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class AcceptancelistController {
    @Autowired
    private AcceptancelistService acceptancelistService;

//    @RequestMapping("/Acceptance/Acceptancelist/List")
//    public Result selectPage(IPage<Acceptancelist> page, @Param(Constants.WRAPPER) Wrapper<Acceptancelist> queryWrapper){
//        return Result.success(("查询成功"),acceptancelistService.selectPage(page,queryWrapper));
//    }
//    public Result getAll(){
//        return Result.success("查询成功",acceptancelistService.getAll());
//    }

    @RequestMapping("/Acceptance/Acceptancelist/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success(("查询成功"),acceptancelistService.selectById(protectId));
    }

    //根据部门名称查询
    @RequestMapping("/Acceptance/Acceptancelist/Department/List")
    public Result selectDepartment(String acceptDepartment){
        return Result.success(("查询成功"),acceptancelistService.selectDepartment(acceptDepartment));
    }
    //根据申请人姓名查询
    @RequestMapping("/Acceptance/Acceptancelist/Acceptpeople/List")
    public Result selectAcceptpeople(String acceptPeople){
        return Result.success(("查询成功"),acceptancelistService.selectAcceptpeople(acceptPeople));
    }

    @RequestMapping("/Acceptance/Acceptancelist/Insert")
    public Result addAcceptancelist(Acceptancelist acceptancelist){
        if(acceptancelistService.addAcceptancelist(acceptancelist)){
            return Result.success("增加成功");
        }
        else
            return Result.error("增加失败");

    }

    @RequestMapping("/Acceptance/Acceptancelist/Update")
    public Result updateAcceptancelist(Acceptancelist acceptancelist) {
        if (acceptancelistService.updateAcceptancelist(acceptancelist)) {
            return Result.success("修改成功");
        }
        else
            return Result.error("修改失败");
    }

    @RequestMapping("/Acceptance/Acceptancelist/Delete")
    public Result deleteAcceptancelist(Integer protectId){
        if(acceptancelistService.deleteAcceptancelist(protectId)){
            return Result.success("删除成功");
        }
        else
            return Result.error("删除失败");
    }

}
