package com.example.informationSystem.service;

import com.example.informationSystem.utils.Result;

public interface ProjectProcessService {
    /**
     * 获取当前项目的流程状态
     * @param projectId 项目id
     * @return 状态标识
     */
    Result catchProcessStatus(Integer projectId);
}
