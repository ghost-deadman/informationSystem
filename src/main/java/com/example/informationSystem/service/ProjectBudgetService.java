package com.example.informationSystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ProjectBudget;
import com.example.informationSystem.entity.vo.ProjectBudgetVO;

import java.text.ParseException;

public interface ProjectBudgetService {
    /**
     * 增加项目预算
     * @param arrangePlanList 资金安排集合
     * @return 是否增加成功
     */
    boolean addProjectBudget(ProjectBudgetVO projectBudgetVO) throws ParseException;

    /**
     * 分页查询项目预算列表
     * @param projectBudgetVO 项目预算VO对象
     * @return 项目预算集合
     */
    Page<ProjectBudget> selectProjectBudgetList(ProjectBudgetVO projectBudgetVO);
}
