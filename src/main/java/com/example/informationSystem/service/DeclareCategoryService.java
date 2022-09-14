package com.example.informationSystem.service;

import com.example.informationSystem.entity.DeclareCategory;
import com.example.informationSystem.mapper.DeclareCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:01
 */
@Service
public class DeclareCategoryService {

    @Autowired
    private DeclareCategoryMapper declareCategoryMapper;

    public boolean addDeclareCategory(DeclareCategory declareCategory){

        declareCategoryMapper.insert(declareCategory);

        return true;

    }

    public boolean updateDeclareCategory(DeclareCategory declareCategory){

        declareCategoryMapper.updateById(declareCategory);

        return true;

    }
    public boolean deleteDeclareCategoryById(Integer id){

        declareCategoryMapper.deleteById(id);

        return true;

    }
    public DeclareCategory selectDeclareCategoryById(String id){

        return declareCategoryMapper.selectById(id);

    }
    public List<DeclareCategory> selectAll(){

        return declareCategoryMapper.selectList(null);

    }

}
