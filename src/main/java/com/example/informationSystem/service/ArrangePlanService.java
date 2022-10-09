package com.example.informationSystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.ArrangePlanDTO;
import com.example.informationSystem.entity.VO.ArrangePlanVO;
import com.example.informationSystem.utils.Result;

public interface ArrangePlanService {
    /**
     * 插入资金使用记录
     * @param planVO 记录vo
     * @return 结果
     */
    Result insertPlan(ArrangePlanVO planVO);


    /**
     * 获取项目资金动向列表
     * @param projectId 项目id
     * @return 结果
     */
    Page<ArrangePlanDTO> getListByProjectId(Integer current, Integer size, String projectId);

    /**
     * 删除
     * @param id id
     * @return 结果
     */
    boolean deleteById(String id);

}
