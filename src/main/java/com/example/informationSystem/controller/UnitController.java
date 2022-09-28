package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.service.UnitService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 15:39
 */
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping("/Overall/Unit/Insert")
    public Result addUnit(Unit unit){

        if(unitService.addUnit(unit)) {

            return Result.success("添加成功");

        }

        return Result.error("添加失败");

    }

    @RequestMapping("/Overall/Unit/List")
    public Result selectAll(){

        return Result.success("查询成功",unitService.selectAll());

    }

    @RequestMapping("/Overall/Unit/Page/List")
    public Result selectAll(long page,long size){

        IPage<Unit> unitPage = unitService.selectAll(page,size);

        return Result.success("查询成功",unitPage);

    }

    @RequestMapping("/Overall/Unit/Id/Info")
    public Result selectUnitById(String id){

        return Result.success("查询成功",unitService.selectUnit(id));

    }

    @RequestMapping("/Overall/Unit/Id/Update")
    public Result updateUnitById(Unit unit){

        if(unitService.updateUnit(unit)){

            return Result.success("更新成功");

        }

        return Result.error("更新失败");

    }

    @RequestMapping("/Overall/Unit/Id/Delete")
    public Result deleteUnitById(String id){

        if(unitService.deleteUnit(id)) {

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }



}
