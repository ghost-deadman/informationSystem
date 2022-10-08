package com.example.informationSystem.controller;


import com.example.informationSystem.entity.AuditOpinion;
import com.example.informationSystem.service.AuditOpinionService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuditOpinionController {
    @Autowired
    private AuditOpinionService auditOpinionService;

    @RequestMapping("/Acceptance/AuditOpinion/List")
    public Result getAll(){
        return Result.success("查询成功",auditOpinionService.getAll());
    }
    @RequestMapping("/Acceptance/AuditOpinion/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success("查询成功",auditOpinionService.selectById(protectId));
    }
    @RequestMapping("/Acceptance/AuditOpinion/projectName/Info")
    public Result selectProject(String projectName){
        return Result.success(("查询成功"),auditOpinionService.selectProject(projectName));
    }

    @RequestMapping("/Acceptance/AuditOpinion/auditPeople/Info")
    public Result selectAuditPeople(String auditPeople){
        return Result.success(("查询成功"),auditOpinionService.selectAuditPeople(auditPeople));
    }

    @RequestMapping("/Acceptance/AuditOpinion/Insert")
    public Result addAuditOpinion(AuditOpinion auditOpinion){
        return Result.success("增加成功",auditOpinionService.addAuditOpinion(auditOpinion));
    }
    @RequestMapping("/Acceptance/AuditOpinion/Update")
    public Result updateAuditOpinion(AuditOpinion auditOpinion){
        return Result.success("修改成功",auditOpinionService.updateAuditOpinion(auditOpinion));
    }
    @RequestMapping("/Acceptance/AuditOpinion/Delete")
    public Result deleteAuditOpinion(Integer auditId){
        return Result.success("删除成功",auditOpinionService.deleteAuditOpinion(auditId));
    }
}
