package com.example.informationSystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectBudget;
import com.example.informationSystem.entity.VO.ProjectBudgetVO;
import com.example.informationSystem.entity.dto.ProjectBudgetDTO;
import com.example.informationSystem.mapper.ProjectBudgetMapper;
import com.example.informationSystem.mapper.ProjectMapper;
import com.example.informationSystem.service.ProjectBudgetService;
import com.example.informationSystem.utils.Result;
import com.example.informationSystem.utils.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Service
public class ProjectBudgetServiceImpl implements ProjectBudgetService {
    @Autowired
    private ProjectBudgetMapper projectBudgetMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Result addProjectBudget(ProjectBudgetVO projectBudgetVO, Integer status) throws ParseException {

        boolean b = new TestVo<ProjectBudgetVO>().voIsFull(projectBudgetVO);
        if (!b) {
            return Result.error("信息不全！");
        } else {
            Project project = projectMapper.selectById(projectBudgetVO.getProjectId());
            if (project == null) {
                return Result.error("参数错误！请联系管理员");
            } else {
                ProjectBudget projectBudget = new ProjectBudget();
                projectBudget.setDate(new Date());
                projectBudget.setDescribes(projectBudgetVO.getDescribes());
                projectBudget.setMoney(projectBudgetVO.getMoney());
                String id = UUID.randomUUID().toString();
                projectBudget.setStatus(status);
                projectBudget.setProjectBudgetId(id);
                project.setProjectBudgetId(id);
                projectBudgetMapper.insert(projectBudget);
                projectMapper.updateById(project);
                if (status == 0) {
                    return Result.success("保存成功");
                } else {
                    return Result.success("提交成功");
                }
            }
        }
    }

    /**
     * 根据用户id分页查询
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态数组
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectAllByUserId(Integer current, Integer size, Integer[] status) {
        // ToDo 获取当前用户id
        String id = "1";
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUserId(iPage, id, status);
    }

    /**
     * 根据用户id分页查询某个状态的
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectOneStatusByUserId(Integer current, Integer size, Integer status) {
        // ToDo 获取当前用户id
        String id = "1";
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUserId(iPage, id, new Integer[]{status});
    }

    /**
     * 根据用户id分页查询
     *
     * @param current 当前页
     * @param size    页大小
     * @param unitId  部门id
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectAllByUnitId(Integer current, Integer size, String unitId, Integer[] status) {
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUnitId(iPage, unitId, status);
    }

    /**
     * 根据用户id分页查询某个状态的
     *
     * @param current 当前页
     * @param size    页大小
     * @param unitId  部门id
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectOneStatusByUnitId(Integer current, Integer size, String unitId, Integer status) {
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUnitId(iPage, unitId, new Integer[]{status});
    }

    /**
     * 根据部门id分页查询全部
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态数组
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectAllByUnitId(Integer current, Integer size, Integer[] status) {
        // ToDo 获取当前用户部门id
        String id = "1";
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUnitId(iPage, id, status);
    }

    /**
     * 根据部门id分页查询某个状态的
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectOneStatusByUnitId(Integer current, Integer size, Integer status) {
        // ToDo 获取当前用户部门id
        String id = "1";
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByUnitId(iPage, id, new Integer[]{status});
    }

    /**
     * 分页查询全部
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectAllPages(Integer current, Integer size, Integer[] status) {
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByStatus(iPage, status);
    }

    /**
     * 分页查询全部
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectAllPages(Integer current, Integer size, Integer status) {
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByStatus(iPage, new Integer[]{status});
    }

    /**
     * 分页查询单个状态的
     *
     * @param current 当前页
     * @param size    页大小
     * @param status  状态
     * @return 分页
     */
    @Override
    public Page<ProjectBudgetDTO> selectOneStatus(Integer current, Integer size, Integer status) {
        Page<ProjectBudgetDTO> iPage = new Page<>(current, size);
        return projectBudgetMapper.getPageByStatus(iPage, new Integer[]{status});
    }

    /**
     * 审核预算申请
     *
     * @param status 状态
     * @return 结果
     */
    @Override
    public boolean checkProjectBudget(String pbId, Integer status) {
        return projectBudgetMapper.checkProjectBudget(pbId, status);
    }

    /**
     * 删除预算
     *
     * @param pbId 预算id
     * @return 结果
     */
    @Override
    public boolean deleteProjectBudget(String pbId) {
        return false;
    }

    /**
     * 获取未审核的数目
     *
     * @param status 状态
     * @return 结果
     */
    @Override
    public Integer getUndoCount(Integer status) {
        return projectBudgetMapper.getCount(status);
    }

    /**
     * 获取用户未审核的数目
     *
     * @param status 状态
     * @return 结果
     */
    @Override
    public Integer getUndoByUserId(Integer status) {
        //ToDO 获取当前用户id
        String userId = "1";
        return projectBudgetMapper.getCountByUserId(userId, status);
    }

    /**
     * 获取单位未审核的数目
     *
     * @param status 状态
     * @return 结果
     */
    @Override
    public Integer getUndoByUnitId(Integer status) {
        //ToDO 获取当前用户id
        String unitId = "1";
        return projectBudgetMapper.getCountByUnitId(unitId, status);
    }


}
