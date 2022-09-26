package com.example.informationSystem.controller;

import com.example.informationSystem.entity.vo.ProjectBudgetVO;
import com.example.informationSystem.entity.vo.ResponseResult;
import com.example.informationSystem.service.ProjectBudgetService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class ProjectBudgetController {
    @Autowired
    private ProjectBudgetService projectBudgetService;

    @RequestMapping("/Build/ProjectBudget/save")
    public Result addProjectBudget(@RequestBody ProjectBudgetVO projectBudgetVO) throws ParseException {

        if( projectBudgetService.addProjectBudget(projectBudgetVO)){
            return Result.success("查询成功");
        }
        else{
            return Result.error("查询失败");
        }

    }

    @GetMapping("/searchProjectBudgetList")
    public ResponseResult searchProjectBudgetList(ProjectBudgetVO projectBudgetVO)throws Exception{
       return new ResponseResult<>(200,"success",projectBudgetService.selectProjectBudgetList(projectBudgetVO));
    }


}
