package com.example.informationSystem.service;

import com.example.informationSystem.entity.AuditOpinion;

import java.util.List;

public interface AuditOpinionService {
    //查询所有审批意见
    List<AuditOpinion> getAll();
    //根据意见id查询审批意见
    AuditOpinion selectById(Integer auditId);
    //根据项目名称查询审批意见
    AuditOpinion selectProject(String projectName);
    //根据审批人姓名查询审批意见
    List<AuditOpinion> selectAuditPeople(String auditPeople);
    //增加审批意见
    Boolean addAuditOpinion(AuditOpinion auditOpinion);
    //修改审批意见
    Boolean updateAuditOpinion(AuditOpinion auditOpinion);
    //删除审批意见
    Boolean deleteAuditOpinion(Integer auditId);
}
