package com.example.informationSystem.controller;

import com.example.informationSystem.service.ProjectProcessService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectProcessController {
    @Autowired
    private ProjectProcessService projectProcessService;
    /**
     * 通过项目id查询该项目的当前状态
     * @param projectId 项目id
     * @return Result对象
     */
    @RequestMapping("/Build/catchProcessStatus/{projectId}")
    public Result catchProcessStatus(@PathVariable("projectId") String projectId){
       return projectProcessService.catchProcessStatus(projectId);
    }
}
