package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Specialist;
import com.example.informationSystem.service.SpecialistService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 16:20
 */
@RestController
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    @RequestMapping("/Overall/Specialist/List")
    public Result selectAll(){

        List<Specialist> specialistList =specialistService.selectAll();

        return Result.success("查询成功",specialistList);

    }

    @RequestMapping("/Overall/Specialist/Page/List")
    public Result selectAll(long page,long size){

        IPage<Specialist> specialistPage = specialistService.selectAll(page,size);

        return Result.success("查询成功",specialistPage);

    }

    @RequestMapping("/Overall/Specialist/Insert")
    public Result addSpecialist(Specialist specialist){

        if(specialistService.addSpecialist(specialist)) {

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }

    @RequestMapping("/Overall/Specialist/Id/Info")
    public Result selectSpecialistById(String id){

        return Result.success("查询成功",specialistService.selectSpecialistById(id));

    }

    @RequestMapping("/Overall/Specialist/Id/Update")
    public Result updateSpecialistById(Specialist specialist){

        if(specialistService.updateSpecialistById(specialist)){

            return Result.success("更新成功");

        }

        return Result.error("更新失败");

    }

    @RequestMapping("/Overall/Specialist/Id/Delete")
    public Result deleteSpecialistById(String id){

        if(specialistService.deleteSpecialistById(id)) {

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

}