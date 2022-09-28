package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ProjectBudget;
import com.example.informationSystem.entity.dto.ProjectBudgetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProjectBudgetMapper extends BaseMapper<ProjectBudget> {
    /**
     * 根据用户id分页查询
     * @param iPage 分页
     * @param uid 用户id
     * @param status 状态数组
     * @return 分页数据
     */
    @Select("SELECT pb.project_budget_id, p.project_name, su.user_name, pb.money, p.unit_id, un.unit_name, pb.opinion_id, pb.date, pb.describes " +
            "FROM project_budget pb , project p, sys_user su, unit un " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND un.unit_id = p.unit_id AND p.project_user_id = su.id " +
            "AND pb.deleted = '0' AND p.project_user_id = #{uid} " +
            "AND pb.status IN (#{status})")
    Page<ProjectBudgetDTO> getPageByUserId(Page<ProjectBudgetDTO> iPage, String uid, Integer[] status);

    /**
     * 根据用户id分页查询
     * @param uid 用户id
     * @param status 状态数组
     * @return 分页数据
     */
    @Select("SELECT COUNT(pb.project_budget_id) " +
            "FROM project_budget pb , project p, sys_user su " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND p.project_user_id = su.id " +
            "AND pb.deleted = '0' AND p.project_user_id = #{uid} " +
            "AND pb.status = #{status}")
    Integer getCountByUserId(String uid, Integer status);


    /**
     * 查询部门的未审核的条数
     * @param unitId 部门id
     * @param status 状态
     * @return 条数
     */
    @Select("SELECT COUNT(pb.project_budget_id) " +
            "FROM project_budget pb , project p " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND pb.deleted = '0' " +
            "AND pb.status = #{status} AND p.unit_id = #{unitId}")
    Integer getCountByUnitId(String unitId, Integer status);

    /**
     * 查询全部的未审核的条数
     * @param status 状态
     * @return 条数
     */
    @Select("SELECT COUNT(pb.project_budget_id) " +
            "FROM project_budget pb , project p " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND pb.deleted = '0' " +
            "AND pb.status = #{status}")
    Integer getCount(Integer status);
    /*
     * 根据部门id分页查询
     * @param iPage 分页
     * @param unitId 部门id
     * @return 分页数据
     */
    @Select("SELECT pb.project_budget_id, p.project_name, su.user_name, pb.money, p.unit_id, un.unit_name,pb.opinion_id, pb.date, pb.describes " +
            "FROM project_budget pb , project p, sys_user su, unit un " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND un.unit_id = p.unit_id AND p.project_user_id = su.id " +
            "AND pb.deleted = '0' AND un.unit_id = #{unitId} AND pb.status IN #{status}")
    Page<ProjectBudgetDTO> getPageByUnitId(Page<ProjectBudgetDTO> iPage, String unitId, Integer[] status);

    /**
     * 全部分页查询
     * @param iPage 分页格式
     * @param status 状态集
     * @return 分页数据
     */
    @Select("SELECT pb.project_budget_id, p.project_name, su.user_name, pb.money, p.unit_id, un.unit_name,pb.opinion_id, pb.date, pb.describes " +
            "FROM project_budget pb , project p, sys_user su, unit un " +
            "WHERE p.project_budget_id = pb.project_budget_id " +
            "AND un.unit_id = p.unit_id AND p.project_user_id = su.id " +
            "AND pb.deleted = '0' AND pb.status IN #{status}")
    Page<ProjectBudgetDTO> getPageByStatus(Page<ProjectBudgetDTO> iPage, Integer[] status);


    /**
     * 审核预算申请
     * @param status 状态
     * @return 结果
     */
    @Update("UPDATE project_budget pb SET pb.status = #{status} WHERE project_budget_id = #{projectBudgetId}")
    boolean checkProjectBudget(String projectBudgetId, Integer status);

    /**
     * 删除预算申请
     * @param projectBudgetId id
     * @return 结果
     */
    @Update("UPDATE project_budget pb SET pb.deleted = '1' WHERE project_budget_id = #{projectBudgetId}")
    boolean deleteProjectBudget(String projectBudgetId);
}
