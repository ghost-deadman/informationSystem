package com.example.informationSystem.controller;

import com.example.informationSystem.service.ProjectFileService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 14:06
 */
@RestController
public class ProjectFileController {

    @Autowired
    private ProjectFileService projectFileService;

    @RequestMapping("/Build/ProjectFile/Unit/List")
    public Result selectAllByUnit(String unitId){

        return Result.success("查询成功",projectFileService.selectProjectFileByUnit(unitId));

    }

    @RequestMapping("/Build/ProjectFile/Unit/Status/List")
    public Result selectByStatus(String unitId ,Integer status){

        return Result.success("查询成功",projectFileService.selectProjectFileByUnitAndStatus(unitId,status));

    }

    @RequestMapping("/Build/ProjectFile/Id/Info")
    public Result selectProjectFileById(String id){

        return Result.success("查询成功",projectFileService.selectProjectFileById(id));

    }

}
