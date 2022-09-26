package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.vo.ResponseResult;
import com.example.informationSystem.service.ProjectDraftService;
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
    public ResponseResult save(ProjectDraft projectDraft){
        projectDraftService.addProjectDraft(projectDraft);
        ResponseResult responseResult = new ResponseResult(200,"success",null);
        return responseResult;
    }

    @GetMapping("/delete")
    public ResponseResult delete(String projectDraftId){
        projectDraftService.deleteProjectDraft(projectDraftId);
        ResponseResult responseResult = new ResponseResult(200,"success",null);
        return responseResult;
    }

    @PostMapping("/update")
    public ResponseResult update(ProjectDraft projectDraft){
        projectDraftService.updateProjectDraft(projectDraft);
        ResponseResult responseResult = new ResponseResult(200,"success",null);
        return responseResult;
    }

    @GetMapping("/selectById")
    public ResponseResult selectById(String id){
        ProjectDraft projectDraft = projectDraftService.selectProjectDraftById(id);
        ResponseResult responseResult = new ResponseResult(200,"success",projectDraft);
        return responseResult;
    }

    @GetMapping("/select")
    public ResponseResult select(){
        List<ProjectDraft> projectDraftList = projectDraftService.selectProjectDraft();
        ResponseResult responseResult = new ResponseResult(200,"success",projectDraftList);
        return responseResult;
    }

}
