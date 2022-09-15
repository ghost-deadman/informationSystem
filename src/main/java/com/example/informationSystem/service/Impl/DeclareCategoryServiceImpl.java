package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DeclareCategory;
import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.mapper.DeclareCategoryMapper;
import com.example.informationSystem.service.DeclareCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:20
 */
@Service
public class DeclareCategoryServiceImpl implements DeclareCategoryService {


    @Autowired
    private DeclareCategoryMapper declareCategoryMapper;

    @Override
    public boolean addDeclareCategory(DeclareCategory declareCategory){

        declareCategoryMapper.insert(declareCategory);

        return true;

    }

    @Override
    public boolean updateDeclareCategory(DeclareCategory declareCategory){

        declareCategoryMapper.updateById(declareCategory);

        return true;

    }

    @Override
    public boolean deleteDeclareCategoryById(String id){

        declareCategoryMapper.deleteById(id);

        return true;

    }

    @Override
    public DeclareCategory selectDeclareCategoryById(String id){

        return declareCategoryMapper.selectById(id);

    }

    @Override
    public List<DeclareCategory> selectAll(){

        return declareCategoryMapper.selectList(null);

    }

    @Override
    public IPage<DeclareCategory> selectPage(long current) {

        IPage<DeclareCategory> page = new Page<>(current,5);

        declareCategoryMapper.selectPage(page,null);

        return page;

    }
}
