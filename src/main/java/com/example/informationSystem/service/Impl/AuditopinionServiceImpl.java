package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.Auditopinion;
import com.example.informationSystem.mapper.AuditopinionMapper;
import com.example.informationSystem.service.AuditopinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditopinionServiceImpl implements AuditopinionService {
     @Autowired
    private AuditopinionMapper auditopinionMapper;

    @Override
    public List<Auditopinion> getAll() {
        return auditopinionMapper.selectList(null);
    }

    @Override
    public Auditopinion selectById(Integer protectId) {
        return auditopinionMapper.selectById(protectId);
    }

    @Override
    public Auditopinion selectProject(String projectName) {
        QueryWrapper<Auditopinion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_name",projectName);
        return auditopinionMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Auditopinion> selectAuditPeople(String auditPeople) {
        QueryWrapper<Auditopinion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("audit_people",auditPeople);
        return auditopinionMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean addAuditopinion(Auditopinion auditopinion) {
        auditopinionMapper.insert(auditopinion);
        return true;
    }

    @Override
    public Boolean updateAuditopinion(Auditopinion auditopinion) {

        auditopinionMapper.updateById(auditopinion);
        return true;
    }

    @Override
    public Boolean deleteAuditopinion(Integer auditId) {

        auditopinionMapper.deleteById(auditId);
        return true;
    }
}
