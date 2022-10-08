package com.example.informationSystem.controller;

import com.example.informationSystem.entity.AcceptanceList;
import com.example.informationSystem.service.AcceptanceListService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class AcceptanceListController {

    @Autowired
    private AcceptanceListService acceptanceListService;

    @RequestMapping("/Acceptance/AcceptanceList/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success(("查询成功"),acceptanceListService.selectById(protectId));
    }

    //根据部门名称查询
    @RequestMapping("/Acceptance/AcceptanceList/Department/List")
    public Result selectDepartment(String acceptDepartment){
        return Result.success(("查询成功"),acceptanceListService.selectDepartment(acceptDepartment));
    }
    //根据申请人姓名查询
    @RequestMapping("/Acceptance/AcceptanceList/Acceptpeople/List")
    public Result selectAcceptpeople(String acceptPeople){
        return Result.success(("查询成功"),acceptanceListService.selectAcceptPeople(acceptPeople));
    }

    @RequestMapping("/Acceptance/AcceptanceList/Insert")
    public Result addAcceptanceList(AcceptanceList AcceptanceList){
        if(acceptanceListService.addAcceptanceList(AcceptanceList)){
            return Result.success("增加成功");
        }
        else {
            return Result.error("增加失败");
        }
    }

    @RequestMapping("/Acceptance/AcceptanceList/Update")
    public Result updateAcceptanceList(AcceptanceList AcceptanceList) {
        if (acceptanceListService.updateAcceptanceList(AcceptanceList)) {
            return Result.success("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }

    @RequestMapping("/Acceptance/AcceptanceList/Delete")
    public Result deleteAcceptanceList(Integer protectId) {
        if (acceptanceListService.deleteAcceptanceList(protectId)) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }

}
