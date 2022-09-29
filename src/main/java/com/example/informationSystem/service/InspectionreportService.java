package com.example.informationSystem.service;


import com.example.informationSystem.entity.Inspectionreport;

import java.util.List;

public interface InspectionreportService {
    //查询所有检查报告
    List<Inspectionreport> getAll();
    //根据项目id查询检查报告
    Inspectionreport selectById(Integer protectId);
    //增加检测报告
    Boolean addInspectionreport(Inspectionreport inspectionreport);
    //修改检测报告
    Boolean updateInspectionreport(Inspectionreport inspectionreport);
    //删除检测报告
    Boolean deleteInspectionreport(Integer inspectionId);
}
