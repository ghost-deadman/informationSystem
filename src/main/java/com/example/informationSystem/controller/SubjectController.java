package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.service.SubjectService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/19 8:29
 */
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/Build/ProjectPrincipal/Subject")
    private Result selectAll(){

        List<Subject> subjectList = subjectService.selectAll();

        return Result.success("查询成功",subjectList);

    }

}
