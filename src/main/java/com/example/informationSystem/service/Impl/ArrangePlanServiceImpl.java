package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ArrangePlan;
import com.example.informationSystem.entity.DTO.ArrangePlanDTO;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.VO.ArrangePlanVO;
import com.example.informationSystem.mapper.ArrangePlanMapper;
import com.example.informationSystem.mapper.ProjectMapper;
import com.example.informationSystem.service.ArrangePlanService;
import com.example.informationSystem.utils.Result;
import com.example.informationSystem.utils.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ArrangePlanServiceImpl implements ArrangePlanService {


    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ArrangePlanMapper arrangePlanMapper;
    /**
     * 插入资金使用记录
     *
     * @param planVO 记录vo
     * @return 结果
     */
    @Override
    public Result insertPlan(ArrangePlanVO planVO) {

        boolean b = new TestVo<ArrangePlanVO>().voIsFull(planVO);
        if (!b) {
            return Result.error("信息不全！");
        } else {
            Project project = projectMapper.selectById(planVO.getProjectId());
            if (project == null) {
                return Result.error("参数错误！请联系管理员");
            } else {
                ArrangePlan arrangePlan = new ArrangePlan();
                String id = UUID.randomUUID().toString();
                arrangePlan.setArrangePlanId(id);
                arrangePlan.setTitle(planVO.getTitle());
                arrangePlan.setMoney(planVO.getMoney());
                arrangePlan.setDescribes(planVO.getDescribes());
                arrangePlan.setDate(planVO.getDate());
                //TODO 获取当前用户id
                String userId = "123456";
                arrangePlan.setPrincipalId(userId);
                arrangePlan.setProjectId(planVO.getProjectId());
                arrangePlan.setCreateTime(LocalDateTime.now());
                int i = arrangePlanMapper.insert(arrangePlan);
                if (i == 1) {
                    return Result.success("提交成功");
                } else {
                    return Result.success("提交失败");
                }
            }
        }
    }

    /**
     * 获取项目资金动向列表
     *
     * @param projectId 项目id
     * @return 结果
     */
    @Override
    public Page<ArrangePlanDTO> getListByProjectId(Integer current, Integer size, String projectId) {
        Page<ArrangePlanDTO> iPage = new Page<>();
        return arrangePlanMapper.getListByProjectId(iPage, projectId);
    }

    /**
     * 删除
     *
     * @param id id
     * @return 结果
     */
    @Override
    public boolean deleteById(String id) {
        int i = arrangePlanMapper.deleteById(id);
        return i == 1;
    }


}
