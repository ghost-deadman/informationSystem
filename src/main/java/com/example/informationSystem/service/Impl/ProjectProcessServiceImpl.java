package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.ProjectProcess;
import com.example.informationSystem.mapper.ProjectProcessMapper;
import com.example.informationSystem.service.ProjectProcessService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProcessServiceImpl implements ProjectProcessService {
    @Autowired
    private ProjectProcessMapper projectProcessMapper;



    @Override
    public Result catchProcessStatus(Integer projectId) {
        /*
        根据所得项目id进行对应的状态查询，并且是按时间顺序查询
         */
        QueryWrapper<ProjectProcess> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id",projectId)
                .orderByAsc("date");
        List<ProjectProcess> listProjectProcess = projectProcessMapper.selectList(queryWrapper);
        return Result.success("200",listProjectProcess);
    }



}
