package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.AuditOpinion;
import com.example.informationSystem.mapper.AuditOpinionMapper;
import com.example.informationSystem.service.AuditOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditOpinionServiceImpl implements AuditOpinionService {
     @Autowired
    private AuditOpinionMapper auditOpinionMapper;

    @Override
    public List<AuditOpinion> getAll() {
        return auditOpinionMapper.selectList(null);
    }

    @Override
    public AuditOpinion selectById(Integer protectId) {
        return auditOpinionMapper.selectById(protectId);
    }

    @Override
    public AuditOpinion selectProject(String projectName) {
        QueryWrapper<AuditOpinion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_name",projectName);
        return auditOpinionMapper.selectOne(queryWrapper);
    }

    @Override
    public List<AuditOpinion> selectAuditPeople(String auditPeople) {
        QueryWrapper<AuditOpinion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("audit_people",auditPeople);
        return auditOpinionMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean addAuditOpinion(AuditOpinion auditOpinion) {
        auditOpinionMapper.insert(auditOpinion);
        return true;
    }

    @Override
    public Boolean updateAuditOpinion(AuditOpinion auditOpinion) {

        auditOpinionMapper.updateById(auditOpinion);
        return true;
    }

    @Override
    public Boolean deleteAuditOpinion(Integer auditId) {

        auditOpinionMapper.deleteById(auditId);
        return true;
    }
}
