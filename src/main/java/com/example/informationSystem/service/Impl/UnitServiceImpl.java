package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.mapper.UnitMapper;
import com.example.informationSystem.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:16
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public boolean addUnit(Unit unit){

        unitMapper.insert(unit);

        return true;

    }

    @Override
    public boolean deleteUnit(String id){

        unitMapper.deleteById(id);

        return true;

    }

    @Override
    public boolean updateUnit(Unit unit){

        unitMapper.updateById(unit);

        return true;

    }

    @Override
    public Unit selectUnit(String id){

        return unitMapper.selectById(id);

    }

    @Override
    public List<Unit> selectAll(){

        return unitMapper.selectList(null);

    }

    @Override
    public IPage<Unit> selectPage(long current) {

        IPage<Unit> page = new Page<>(current,5);

        unitMapper.selectPage(page,null);

        return page;

    }

}
