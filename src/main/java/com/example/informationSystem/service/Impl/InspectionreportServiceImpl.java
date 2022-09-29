package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.Inspectionreport;
import com.example.informationSystem.mapper.InspectionreportMapper;
import com.example.informationSystem.service.InspectionreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectionreportServiceImpl implements InspectionreportService {

    @Autowired
    private InspectionreportMapper inspectionreportMapper;

    @Override
    public List<Inspectionreport> getAll() {
        return inspectionreportMapper.selectList(null);
    }

    @Override
    public Inspectionreport selectById(Integer inspectionId) {
        return inspectionreportMapper.selectById(inspectionId);
    }

    @Override
    public Boolean addInspectionreport(Inspectionreport inspectionreport) {
        inspectionreportMapper.insert(inspectionreport);
        return true;
    }

    @Override
    public Boolean updateInspectionreport(Inspectionreport inspectionreport) {
        inspectionreportMapper.updateById(inspectionreport);
        return true;
    }

    @Override
    public Boolean deleteInspectionreport(Integer inspectionId) {
        inspectionreportMapper.deleteById(inspectionId);
        return true;
    }
}
