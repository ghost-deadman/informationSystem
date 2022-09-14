package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.service.UnitService;
import com.example.informationSystem.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 15:39
 */
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

//    @PostMapping
//    public ResponseResult<Unit> addUnit(@RequestBody Unit unit) throws Exception {
//
//        ResponseResult<Unit> unitResponseResult = new ResponseResult<Unit>();
//
//        if (!unitService.addUnit(unit)) {
//
//            unitResponseResult.setCode(55555);
//
//            unitResponseResult.setMsg("插入出错了");
//
//        }
//        return empResultVO;
//
//    }




}
