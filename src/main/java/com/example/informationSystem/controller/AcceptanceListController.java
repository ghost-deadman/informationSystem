package com.example.informationSystem.controller;

import com.example.informationSystem.entity.AcceptanceList;
import com.example.informationSystem.service.AcceptanceListService;
import com.example.informationSystem.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "项目验收")
public class AcceptanceListController {

    @Autowired
    private AcceptanceListService acceptanceListService;

    @GetMapping("/Acceptance/AcceptanceList/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success(("查询成功"),acceptanceListService.selectById(protectId));
    }

    //根据部门名称查询
    @GetMapping("/Acceptance/AcceptanceList/Department/List")
    public Result selectDepartment(String acceptDepartment){
        return Result.success(("查询成功"),acceptanceListService.selectDepartment(acceptDepartment));
    }
    //根据申请人姓名查询
    @GetMapping("/Acceptance/AcceptanceList/Acceptpeople/List")
    public Result selectAcceptpeople(String acceptPeople){
        return Result.success(("查询成功"),acceptanceListService.selectAcceptPeople(acceptPeople));
    }

    @PostMapping("/Acceptance/AcceptanceList/Insert")
    public Result addAcceptanceList(AcceptanceList AcceptanceList){
        if(acceptanceListService.addAcceptanceList(AcceptanceList)){
            return Result.success("增加成功");
        }
        else {
            return Result.error("增加失败");
        }
    }

    @PostMapping("/Acceptance/AcceptanceList/Update")
    public Result updateAcceptanceList(AcceptanceList AcceptanceList) {
        if (acceptanceListService.updateAcceptanceList(AcceptanceList)) {
            return Result.success("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }

    @GetMapping("/Acceptance/AcceptanceList/Delete")
    public Result deleteAcceptanceList(Integer protectId) {
        if (acceptanceListService.deleteAcceptanceList(protectId)) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }

}
