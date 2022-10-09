package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.service.ProjectFileService;
import com.example.informationSystem.utils.FileUtils;
import com.example.informationSystem.utils.Pager;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 14:06
 */
@RestController
public class ProjectFileController {

    @Autowired
    private FileUtils fileUpload;

    @Autowired
    private ProjectFileService projectFileService;

    @RequestMapping("/Build/ProjectFile/Id/Download/Info")
    public ResponseEntity<byte[]> downLoadFile(String fileId, HttpSession session) throws IOException {

        System.out.println(fileId);

        ProjectFile projectFile = projectFileService.selectProjectFileById(fileId);

        return fileUpload.testResponseEntity(projectFile,session);

    }

    @RequestMapping("/Build/ProjectFile/Unit/Page/List")
    public Result selectAllByUnit(String unitId,long page,long size){

        Pager<ProjectFile> projectFilePage = projectFileService.selectProjectFileByUnit(unitId,page,size);

        return Result.success("查询成功",projectFilePage);

    }

    @RequestMapping("/Build/ProjectFile/Unit/List")
    public Result selectAllByUnit(String unitId){

        List<ProjectFile> projectFileList = projectFileService.selectProjectFileByUnit(unitId);

        return Result.success("查询成功",projectFileList);

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
