package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Inspectionreport;
import com.example.informationSystem.service.InspectionreportService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class InspectionreportController {
    @Autowired
    private InspectionreportService inspectionreportService;
    @RequestMapping("/Acceptance/Inspectionreport/List")
    public Result getAll(){
        return Result.success("查询成功",inspectionreportService.getAll());
    }
    @RequestMapping("/Acceptance/Inspectionreport/Id/Info")
    public Result selectById(Integer protectId){
        return Result.success("查询成功",inspectionreportService.selectById(protectId));
    }
    @RequestMapping("/Acceptance/Inspectionreport/Insert")
    public Result addInspectionreport(Inspectionreport inspectionreport){
        return Result.success("增加成功",inspectionreportService.addInspectionreport(inspectionreport));
    }
    @RequestMapping("/Acceptance/Inspectionreport/Update")
    public Result updateInspectionreport(Inspectionreport inspectionreport){
        return Result.success("修改成功",inspectionreportService.updateInspectionreport(inspectionreport));
    }
    @RequestMapping("/Acceptance/Inspectionreport/Delete")
    public Result deleteInspectionreport(Integer inspectionId){
        return Result.success("删除成功",inspectionreportService.deleteInspectionreport(inspectionId));
    }

}
