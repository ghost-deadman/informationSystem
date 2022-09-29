package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Acceptancelist;
import com.example.informationSystem.mapper.AcceptancelistMapper;
import com.example.informationSystem.service.AcceptancelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptancelistServiceImpl implements AcceptancelistService {

    @Autowired
    private AcceptancelistMapper acceptancelistMapper;

    @Override
    public List<Acceptancelist> getAll() {
        return acceptancelistMapper.selectList(null);
    }

    @Override
    public Acceptancelist selectById(Integer protectId) {
        return acceptancelistMapper.selectById(protectId);
    }

    @Override
    public Boolean addAcceptancelist(Acceptancelist acceptancelist) {
        acceptancelistMapper.insert(acceptancelist);
        return true;
    }

    @Override
    public Boolean updateAcceptancelist(Acceptancelist acceptancelist) {
         acceptancelistMapper.updateById(acceptancelist);
         return true;
    }

    @Override
    public Boolean deleteAcceptancelist(Integer protectId) {
        acceptancelistMapper.deleteById(protectId);
        return true;
    }

    //根据部门查询
    @Override
    public List<Acceptancelist> selectDepartment(String acceptDepartment) {
        QueryWrapper<Acceptancelist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accept_department",acceptDepartment);
        return acceptancelistMapper.selectList(queryWrapper);
    }

    //根据申请人姓名查询
    @Override
    public List<Acceptancelist> selectAcceptpeople(String acceptPeople) {
        QueryWrapper<Acceptancelist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accept_people",acceptPeople);
        return acceptancelistMapper.selectList(queryWrapper);
    }

}
