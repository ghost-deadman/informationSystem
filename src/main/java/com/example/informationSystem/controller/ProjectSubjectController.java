package com.example.informationSystem.controller;

import com.example.informationSystem.service.ProjectSubjectService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectSubjectController {
    @Autowired
    private ProjectSubjectService projectSubjectService;

    @RequestMapping("/subjectDataAnalysis")
    public Result subjectDataAnalysis(){
        return Result.success("200",projectSubjectService.subjectDataAnalysis());
    }
}
