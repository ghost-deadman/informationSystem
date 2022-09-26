package com.example.informationSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.ArrangePlan;
import com.example.informationSystem.entity.ProjectBudget;
import com.example.informationSystem.entity.vo.ProjectBudgetVO;
import com.example.informationSystem.mapper.ArrangePlanMapper;
import com.example.informationSystem.mapper.ProjectBudgetMapper;
import com.example.informationSystem.service.ProjectBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectBudgetServiceImpl implements ProjectBudgetService {
    @Autowired
    private ProjectBudgetMapper projectBudgetMapper;
    @Autowired
    private ArrangePlanMapper arrangePlanMapper;

    @Override
    public boolean addProjectBudget(ProjectBudgetVO projectBudgetVO) throws ParseException {
        /*
        1.首先获取当前Date对象，并创建一个ProjectBudget对象（项目预算），并且计算传入的资金安排集合的总金额
        2.然后依次对传入的资金安排对象集合进行赋值，如：日期，项目预算id.
        3.ProjectBudget对象/arrangePlanList对象依次存入数据库
         */

        //获取当前Date对象，并转化成yyyy-mm-dd类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        Date myDate = sdf.parse(dateStr);

        ProjectBudget projectBudget = new ProjectBudget();
        int allCount = 0;
//        for (ArrangePlan arrangePlan : arrangePlanList) {
//            arrangePlan.setProjectBudgetId(projectBudget.getProjectBudgetId());
//            arrangePlan.setDate(myDate);
//            allCount += Integer.parseInt(arrangePlan.getMoney());
//            arrangePlanMapper.insert(arrangePlan);
//        }

        projectBudget.setDate(myDate);
        projectBudget.setMoney(String.valueOf(allCount));
        projectBudgetMapper.insert(projectBudget);
        return true;
    }


    @Override
    public Page<ProjectBudget> selectProjectBudgetList(ProjectBudgetVO projectBudgetVO) {
        /*
        1.首先
         */
        Page<ProjectBudget> page = new Page<>(projectBudgetVO.getCurrentPage(),projectBudgetVO.getPageSize());
        QueryWrapper<ProjectBudget> queryWrapper = new QueryWrapper<>();

        if(projectBudgetVO.getDate() != null) {
            queryWrapper.eq("date", new SimpleDateFormat("yyyy-MM-dd").format(projectBudgetVO.getDate()));
        }

//        if(projectBudgetVO.getIfConstructionPass()!=null) {
//            if (projectBudgetVO.getIfConstructionPass() == 1) {
//                queryWrapper.ne("if_construction_pass", -1);
//            } else {
//                queryWrapper.eq("if_construction_pass", -1);
//            }
//        }
//        if(projectBudgetVO.getIfRelevantPass() != null) {
//            if (projectBudgetVO.getIfRelevantPass() == 1) {
//                queryWrapper.ne("if_relevant_pass", -1);
//            } else {
//                queryWrapper.eq("if_relevant_pass", -1);
//            }
//        }
        return  projectBudgetMapper.selectPage(page,queryWrapper);

    }
}
