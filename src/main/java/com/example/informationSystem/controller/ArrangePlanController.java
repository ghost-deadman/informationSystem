package com.example.informationSystem.controller;

import com.example.informationSystem.entity.ArrangePlan;
import com.example.informationSystem.service.ArrangePlanService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/arrangePlan")
public class ArrangePlanController {
    @Autowired
    private ArrangePlanService arrangePlanService;

    @PostMapping("/save")
    public Result save(  @RequestBody List<ArrangePlan> arrangePlanList){
        if(arrangePlanList != null) {
            for (ArrangePlan arrangePlan : arrangePlanList) {
                System.out.println(arrangePlan);
            }
        }

       return Result.success( "666");

    }

//    public ResponseResult save( ArrangePlan arrangePlan){
//        if(arrangePlan != null) {
//            System.out.println(arrangePlan);
//        }
//
//        System.out.println(111);
//        return new ResponseResult(200,"666");
//
//    }
}
