package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.AcceptanceList;
import com.example.informationSystem.mapper.AcceptanceListMapper;
import com.example.informationSystem.service.AcceptanceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptanceListServiceImpl implements AcceptanceListService {

    @Autowired
    private AcceptanceListMapper acceptanceListMapper;

    @Override
    public List<AcceptanceList> getAll() {
        return acceptanceListMapper.selectList(null);
    }

    @Override
    public AcceptanceList selectById(Integer protectId) {
        return acceptanceListMapper.selectById(protectId);
    }

    @Override
    public Boolean addAcceptanceList(AcceptanceList acceptanceList) {
        acceptanceListMapper.insert(acceptanceList);
        return true;
    }

    @Override
    public Boolean updateAcceptanceList(AcceptanceList acceptanceList) {
         acceptanceListMapper.updateById(acceptanceList);
         return true;
    }

    @Override
    public Boolean deleteAcceptanceList(Integer protectId) {
        acceptanceListMapper.deleteById(protectId);
        return true;
    }

    //根据部门查询
    @Override
    public List<AcceptanceList> selectDepartment(String acceptDepartment) {
        QueryWrapper<AcceptanceList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accept_department",acceptDepartment);
        return acceptanceListMapper.selectList(queryWrapper);
    }

    //根据申请人姓名查询
    @Override
    public List<AcceptanceList> selectAcceptPeople(String acceptPeople) {
        QueryWrapper<AcceptanceList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accept_people",acceptPeople);
        return acceptanceListMapper.selectList(queryWrapper);
    }

}
