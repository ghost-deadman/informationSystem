package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.informationSystem.entity.ProjectProcess;
import com.example.informationSystem.mapper.ProjectProcessMapper;
import com.example.informationSystem.service.ProjectProcessService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectProcessServiceImpl implements ProjectProcessService {
    @Autowired
    private ProjectProcessMapper projectProcessMapper;



    @Override
    public Result catchProcessStatus(String projectId) {
        /*
        根据所得项目id进行对应的状态查询，并且是按时间顺序查询
         */
        QueryWrapper<ProjectProcess> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id",projectId)
                .orderByAsc("date");
        List<ProjectProcess> listProjectProcess = projectProcessMapper.selectList(queryWrapper);
        return Result.success("200",listProjectProcess);
    }

    @Override
    public void  addProjectProcess(String projectId,String status){

        ProjectProcess projectProcess = new ProjectProcess();

        projectProcess.setProjectProcessId(String.valueOf(UUID.randomUUID()));

        projectProcess.setProjectId(projectId);

        projectProcess.setStatus(status);

        projectProcess.setLocalDateTime(LocalDateTime.now());

        projectProcessMapper.insert(projectProcess);

    }



}
