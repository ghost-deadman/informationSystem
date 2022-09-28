package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Specialist;
import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.mapper.SpecialistMapper;
import com.example.informationSystem.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 16:15
 */
@Service
public class SpecialistServiceImpl implements SpecialistService {

    @Autowired
    private SpecialistMapper specialistMapper;

    @Override
    public boolean addSpecialist(Specialist specialist) {

        specialistMapper.insert(specialist);

        return true;

    }

    @Override
    public boolean deleteSpecialistById(String id) {

        specialistMapper.deleteById(id);

        return true;

    }

    @Override
    public boolean updateSpecialistById(Specialist specialist) {

        specialistMapper.updateById(specialist);

        return true;

    }

    @Override
    public Specialist selectSpecialistById(String id) {

        return specialistMapper.selectById(id);

    }

    @Override
    public List<Specialist> selectAll() {

        return specialistMapper.selectList(null);

    }

    @Override
    public IPage<Specialist> selectAll(long current, long size) {

        IPage<Specialist> specialistPage = new Page<>(current,size);

        specialistMapper.selectPage(specialistPage,null);

        return specialistPage;

    }
}
