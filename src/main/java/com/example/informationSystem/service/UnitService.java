package com.example.informationSystem.service;

import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 9:03
 */
@Service
public class UnitService {

    @Autowired
    private UnitMapper unitMapper;

    public boolean addUnit(Unit unit){

        unitMapper.insert(unit);

        return true;

    }

    public boolean deleteUnit(String id){

        unitMapper.deleteById(id);

        return true;

    }

    public boolean updateUnit(Unit unit){

        unitMapper.updateById(unit);

        return true;

    }

    public Unit selectUnit(String id){

        return unitMapper.selectById(id);

    }

}
