package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.service.ProjectDraftService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 10:38
 */
@RestController
public class ProjectDraftController {

    @Autowired
    private ProjectDraftService projectDraftService;

    @RequestMapping("/ProjectDaft/ProjectDraft/Insert")
    public Result addProjectDaft(ProjectDraft projectDraft){

        if(projectDraftService.addProjectDraft(projectDraft)){

            return Result.success("添加成功");

        }

        return Result.error("添加失败");
    }

    @RequestMapping("/Build/ProjectDaft/Project/Info")
    public Result selectProjectDaftByProjectId(String projectId){

        List<ProjectDraft> projectDraftList = projectDraftService.selectProjectDraftByProjectId(projectId);

        return Result.success("查询成功",projectDraftList);

    }

    @RequestMapping("/Build/ProjectDaft/Id/Update")
    public Result updateProjectDaftById(ProjectDraft projectDraft){

        if(projectDraftService.updateProjectDraft(projectDraft)){

            return Result.success("修改成功");

        }

        return Result.error("修改失败");

    }

    @RequestMapping("/Build/ProjectDaft/Id/Delete")
    public Result deleteProjectDaftById(String id){

        if(projectDraftService.deleteProjectDraft(id)){

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

}
