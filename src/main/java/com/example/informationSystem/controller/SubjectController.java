package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.service.SubjectService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = {"/Build/Subject/List","/Overall/Subject/List"})
    public Result selectAll(){

        List<Subject> subjectList = subjectService.selectAll();

        return Result.success("查询成功",subjectList);

    }

    @RequestMapping("/Overall/Subject/Page/List")
    public Result selectAll(long page,long size){

        IPage<Subject> subjectPage = subjectService.selectAll(page,size);

        return Result.success("查询成功",subjectPage);

    }

    @RequestMapping("/Overall/Subject/Insert")
    public Result addSubject(Subject subject){

        if(subjectService.addSubject(subject)) {

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }

    @RequestMapping("/Overall/Subject/Id/Info")
    public Result selectSubjectById(String id){

        return Result.success("查询成功",subjectService.selectSubjectById(id));

    }

    @RequestMapping("/Overall/Subject/Id/Update")
    public Result updateSubjectById(Subject subject){

        if(subjectService.updateSubject(subject)){

            return Result.success("更新成功");

        }

        return Result.error("更新失败");

    }

    @RequestMapping("/Overall/Subject/Id/Delete")
    public Result deleteSubjectById(String id){

        if(subjectService.deleteSubject(id)) {

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

}
