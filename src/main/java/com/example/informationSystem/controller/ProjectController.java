package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.FileUpload;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 9:33
 */
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FileUpload fileUpload;

    /**
     * 文件上传
     * @param file 文件
     * @return 是否成功
     */
    @RequestMapping("/Build/Project/Insert")
    public Result addProject(ProjectVO projectVO, @RequestParam(name = "file",required = false) MultipartFile file) throws IOException {

            String pathList = fileUpload.upload(file);

            if(pathList != null){

                  if(projectService.addProject(projectVO,pathList)){


                      return Result.success("文件成功收到");

                  }

            }

        return Result.error("失败没有收到文件");

    }

    @RequestMapping("/Build/Project/Id/Update")
    public Result updateProjectById(Project project) {

        if(projectService.updateProject(project)){

            return Result.success("更新成功");

        }

        return Result.error("更新失败");

    }

    @RequestMapping("/Build/Project/Id/Delete")
    public Result deleteProjectById(String id) {

        if(projectService.deleteProjectById(id)){

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

    @GetMapping("/Build/Project/Id/Info")
    public Result selectProjectById(String id) {

       return Result.success("查询成功",projectService.selectProjectById(id));

    }

    @RequestMapping("/Build/Project/User/List")
    public Result selectProjectByUserId(String userId) {

       return Result.success("查询成功",projectService.selectProjectByUserId(userId));

    }

}
