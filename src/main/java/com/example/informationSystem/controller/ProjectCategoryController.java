package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.ProjectCategory;
import com.example.informationSystem.service.ProjectCategoryService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 15:37
 */
@RestController
public class ProjectCategoryController {

    @Autowired
    private ProjectCategoryService projectCategoryService;

    @RequestMapping("/Overall/ProjectCategory/Insert")
    public Result addProjectCategory(ProjectCategory projectCategory){

        if(projectCategoryService.addProjectCategory(projectCategory)) {

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }

    @RequestMapping("/Overall/ProjectCategory/Page/List")
    public Result selectAll(long page,long size){

        IPage<ProjectCategory> projectCategoryPage = projectCategoryService.selectAll(page,size);

        return Result.success("查询成功",projectCategoryPage);

    }

    @RequestMapping("/Overall/ProjectCategory/List")
    public Result selectAll(){

        return Result.success("查询成功",projectCategoryService.selectAll());

    }

    @RequestMapping("/Overall/ProjectCategory/Id/Info")
    public Result selectProjectCategoryById(String id){

        return Result.success("查询成功",projectCategoryService.selectProjectCategoryById(id));

    }

    @RequestMapping("/Overall/ProjectCategory/Id/Update")
    public Result updateProjectCategoryById(ProjectCategory projectCategory){

        if(projectCategoryService.updateProjectCategory(projectCategory)){

            return Result.success("更新成功");

        }

        return Result.error("更新失败");

    }

    @RequestMapping("/Overall/ProjectCategory/Id/Delete")
    public Result deleteProjectCategoryById(String id){

        if(projectCategoryService.deleteProjectCategoryById(id)) {

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }


}
