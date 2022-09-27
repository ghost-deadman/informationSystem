package com.example.informationSystem.controller;

import com.example.informationSystem.entity.VO.ProjectBudgetVO;
import com.example.informationSystem.entity.vo.ResponseResult;
import com.example.informationSystem.service.ProjectBudgetService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/ProjectBudget")
public class ProjectBudgetController {
    @Autowired
    private ProjectBudgetService projectBudgetService;

    @PostMapping("/addProjectBudget")
    public Result addProjectBudget(@RequestBody ProjectBudgetVO projectBudgetVO) throws ParseException {

        if( projectBudgetService.addProjectBudget(projectBudgetVO)){
            return Result.success("增加成功");
        }
        else{
            return Result.error("增加失败");
        }

    }

    @GetMapping("/searchProjectBudgetList")
    public ResponseResult searchProjectBudgetList(ProjectBudgetVO projectBudgetVO)throws Exception{
       return new ResponseResult<>(200,"success",projectBudgetService.selectProjectBudgetList(projectBudgetVO));
    }


}
