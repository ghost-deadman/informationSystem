package com.example.informationSystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.VO.ProjectBudgetVO;
import com.example.informationSystem.entity.dto.ProjectBudgetDTO;
import com.example.informationSystem.utils.Result;

import java.text.ParseException;

public interface ProjectBudgetService {
    /**
     * 增加项目预算
     * @param projectBudgetVO 项目预算集合
     * @return 是否增加成功
     */
    Result addProjectBudget(ProjectBudgetVO projectBudgetVO, Integer status) throws ParseException;


    /**
     * 根据用户id分页查询
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectAllByUserId(Integer current, Integer size, Integer[] status);

    /**
     * 根据用户id分页查询某个状态的
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectOneStatusByUserId(Integer current, Integer size, Integer status);

    /**
     * 根据用户id分页查询
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectAllByUnitId(Integer current, Integer size, String unitId, Integer[] status);

    /**
     * 根据用户id分页查询某个状态的
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectOneStatusByUnitId(Integer current, Integer size, String unitId, Integer status);

    /**
     * 根据部门id分页查询全部
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectAllByUnitId(Integer current, Integer size, Integer[] status);

    /**
     * 根据部门id分页查询某个状态的
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectOneStatusByUnitId(Integer current, Integer size, Integer status);

    /**
     * 分页查询全部
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectAllPages(Integer current, Integer size, Integer[] status);

    /**
     * 分页查询全部
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectAllPages(Integer current, Integer size, Integer status);

    /**
     * 分页查询单个状态的
     * @param current 当前页
     * @param size 页大小
     * @return 分页
     */
    Page<ProjectBudgetDTO> selectOneStatus(Integer current, Integer size, Integer status);

    /**
     * 审核预算申请
     * @param status 状态
     * @return 结果
     */
    boolean checkProjectBudget(String pbId, Integer status);

    /**
     * 删除预算
     * @param pbId 预算id
     * @return 结果
     */
    boolean deleteProjectBudget(String pbId);
    /**
     * 获取未审核的数目
     * @param status 状态
     * @return 结果
     */
    Integer getUndoCount(Integer status);
    /**
     * 获取用户未审核的数目
     * @param status 状态
     * @return 结果
     */
    Integer getUndoByUserId(Integer status);
    /**
     * 获取单位未审核的数目
     * @param status 状态
     * @return 结果
     */
    Integer getUndoByUnitId(Integer status);

}
