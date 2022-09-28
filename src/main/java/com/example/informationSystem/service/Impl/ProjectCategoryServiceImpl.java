package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ProjectCategory;
import com.example.informationSystem.mapper.ProjectCategoryMapper;
import com.example.informationSystem.service.ProjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:20
 */
@Service
public class ProjectCategoryServiceImpl implements ProjectCategoryService {


    @Autowired
    private ProjectCategoryMapper projectCategoryMapper;

    @Override
    public boolean addProjectCategory(ProjectCategory declareCategory){

        projectCategoryMapper.insert(declareCategory);

        return true;

    }

    @Override
    public boolean updateProjectCategory(ProjectCategory declareCategory){

        projectCategoryMapper.updateById(declareCategory);

        return true;

    }

    @Override
    public boolean deleteProjectCategoryById(String id){

        projectCategoryMapper.deleteById(id);

        return true;

    }

    @Override
    public ProjectCategory selectProjectCategoryById(String id){

        return projectCategoryMapper.selectById(id);

    }

    @Override
    public List<ProjectCategory> selectAll(){

        return projectCategoryMapper.selectList(null);

    }

    @Override
    public IPage<ProjectCategory> selectAll(long page, long size) {

        IPage<ProjectCategory> projectCategoryPage = new Page<>(page,size);

        projectCategoryMapper.selectPage(projectCategoryPage,null);

        return projectCategoryPage;

    }

}
