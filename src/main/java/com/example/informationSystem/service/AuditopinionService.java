package com.example.informationSystem.service;

import com.example.informationSystem.entity.Auditopinion;

import java.util.List;

public interface AuditopinionService {
    //查询所有审批意见
    List<Auditopinion> getAll();
    //根据意见id查询审批意见
    Auditopinion selectById(Integer auditId);
    //根据项目id查询审批意见
    Auditopinion selectProject(String projectId);
    //根据审批人姓名查询审批意见
    List<Auditopinion> selectAuditPeople(String auditPeople);
    //增加审批意见
    Boolean addAuditopinion(Auditopinion auditopinion);
    //修改审批意见
    Boolean updateAuditopinion(Auditopinion auditopinion);
    //删除审批意见
    Boolean deleteAuditopinion(Integer auditId);
}
