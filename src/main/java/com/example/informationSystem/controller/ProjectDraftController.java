package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.service.ProjectDraftService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projectDraft")
public class ProjectDraftController {
    @Autowired
    ProjectDraftService projectDraftService;

    @PostMapping("/save")
    public Result save(ProjectDraft projectDraft){
        projectDraftService.addProjectDraft(projectDraft);
        return Result.success("success");
    }

    @GetMapping("/delete")
    public Result delete(String projectDraftId){
        projectDraftService.deleteProjectDraft(projectDraftId);
        return Result.success("success");
    }

    @PostMapping("/update")
    public Result update(ProjectDraft projectDraft){
        projectDraftService.updateProjectDraft(projectDraft);
        return Result.success("success");
    }

    @GetMapping("/selectById")
    public Result selectById(String id){
        ProjectDraft projectDraft = projectDraftService.selectProjectDraftById(id);
        return Result.success("success",projectDraft);
    }

    @GetMapping("/select")
    public Result select(){
        List<ProjectDraft> projectDraftList = projectDraftService.selectProjectDraft();
        return Result.success("success",projectDraftList);
    }

}
