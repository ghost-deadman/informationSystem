package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.DTO.ProjectDraftDTO;
import com.example.informationSystem.entity.ProjectDraft;
import com.example.informationSystem.entity.VO.ProjectDraftVO;
import com.example.informationSystem.service.ProjectDraftService;
import com.example.informationSystem.utils.FileUtils;
import com.example.informationSystem.utils.Result;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 10:38
 */
@RestController
public class ProjectDraftController {

    @Autowired
    private ProjectDraftService projectDraftService;

    @Autowired
    private FileUtils fileUpload;

    @RequestMapping("/Build/ProjectDraft/Insert")
    public Result addProjectDraft(ProjectDraft projectDraft, @RequestParam(name = "file", required = false) List<MultipartFile> file) throws IOException {

        List<String> pathList = fileUpload.upload(file);

        if (projectDraftService.addProjectDraft(projectDraft, pathList)) {


            return Result.success("草稿创建成功");

        }

        return Result.error("草稿创建失败");

    }

    @RequestMapping("/Build/ProjectDraft/Project/Page/List")
    public Result selectProjectDraftByProjectId(String projectId, long page, long size) {

        IPage<ProjectDraft> projectDraftPage = projectDraftService.selectProjectDraftByProjectId(projectId, page, size);

        return Result.error("查询成功", projectDraftPage);
    }

    @RequestMapping("/Build/ProjectDraft/Project/Info")
    public Result selectProjectDraftById(String projectDraftId) {

        return Result.success("查询成功", projectDraftService.selectProjectDraftById(projectDraftId));

    }

    @RequestMapping("/Build/ProjectDraft/Project/List")
    public Result selectProjectDraftByProjectId(@RequestParam String projectId) {

        List<ProjectDraft> projectDraftList = projectDraftService.selectProjectDraftByProjectId(projectId);

        return Result.success("查询成功", projectDraftList);

    }

    @RequestMapping("/Build/ProjectDraft/Id/Update")
    public Result updateProjectDraftById(ProjectDraft projectDraft, @RequestParam(name = "file") List<MultipartFile> file) throws IOException {

        if (file == null) {


            if (projectDraftService.updateProjectDraft(projectDraft)) {

                return Result.success("修改成功");

            }

        } else {

            List<String> pathList = fileUpload.upload(file);

            if (projectDraftService.updateProjectDraft(projectDraft, pathList)) {

                return Result.success("文件成功修改");

            }

        }

        return Result.error("修改失败");

    }

    @RequestMapping("/Build/ProjectDraft/User/List")
    public Result selectAllProjectDraftByUserId(String userId,long page,long size){

        IPage<ProjectDraft> projectDraftPage = projectDraftService.selectAllProjectDraftByUserId(userId,page,size);

        return Result.success("查询成功",projectDraftPage);

    }

    @RequestMapping("/Build/ProjectDraft/Id/Delete")
    public Result deleteProjectDraftById(String id) {

        if (projectDraftService.deleteProjectDraft(id)) {

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

    @RequestMapping("/Build/ProjectDraft/Id/Submit/Update")
    public Result submitProjectDraftById(String projectDraftId){

        if(projectDraftService.submitProjectDraft(projectDraftId)){

            return Result.success("提交成功");

        }

        return Result.error("提交失败");

    }

}
