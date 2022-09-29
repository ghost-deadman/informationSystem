package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Material;
import com.example.informationSystem.service.MaterialService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @RequestMapping("/Acceptance/Material/List")
    public Result getAll(){
        return Result.success("查询成功",materialService.getAll());
    }
    @RequestMapping("/Acceptance/Material/Id/List")
    public Result selectById(Integer materialId){
        return Result.success("查询成功",materialService.selectById(materialId));
    }
    @RequestMapping("/Acceptance/Material/Insert")
    public Result addMaterial(Material material){
        return Result.success("增加成功",materialService.addMaterial(material));
    }
    @RequestMapping("/Acceptance/Material/Update")
    public Result updateMaterial(Material material){
        return Result.success("修改成功",materialService.updateMaterial(material));
    }
    @RequestMapping("/Acceptance/Material/Delete")
    public Result deleteMaterial(Integer materialId){
        return Result.success("删除成功",materialService.deleteMaterial(materialId));
    }
}
