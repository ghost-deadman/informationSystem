package com.example.informationSystem.controller;


import com.example.informationSystem.entity.Auditopinion;
import com.example.informationSystem.service.AuditopinionService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuditopinionController {
    @Autowired
    private AuditopinionService auditopinionService;

    @RequestMapping("/Acceptance/Auditopinion/List")
    public Result getAll(){
        return Result.success("查询成功",auditopinionService.getAll());
    }
    @RequestMapping("/Acceptance/Auditopinion/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success("查询成功",auditopinionService.selectById(protectId));
    }
    @RequestMapping("/Acceptance/Auditopinion/projectName/Info")
    public Result selectProject(String projectName){
        return Result.success(("查询成功"),auditopinionService.selectProject(projectName));
    }

    @RequestMapping("/Acceptance/Auditopinion/auditPeople/Info")
    public Result selectAuditPeople(String auditPeople){
        return Result.success(("查询成功"),auditopinionService.selectAuditPeople(auditPeople));
    }

    @RequestMapping("/Acceptance/Auditopinion/Insert")
    public Result addAuditopinion(Auditopinion auditopinion){
        return Result.success("增加成功",auditopinionService.addAuditopinion(auditopinion));
    }
    @RequestMapping("/Acceptance/Auditopinion/Update")
    public Result updateAuditopinion(Auditopinion auditopinion){
        return Result.success("修改成功",auditopinionService.updateAuditopinion(auditopinion));
    }
    @RequestMapping("/Acceptance/Auditopinion/Delete")
    public Result deleteAuditopinion(Integer auditId){
        return Result.success("删除成功",auditopinionService.deleteAuditopinion(auditId));
    }
}
