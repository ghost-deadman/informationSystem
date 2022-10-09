package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.informationSystem.entity.AcceptanceList;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author pcdn
 */
public interface AcceptanceListService {

    //查询所有验收表
    List<AcceptanceList> getAll();
    //根据id查询验收表
    AcceptanceList selectById(Integer acceptId);
    //增加验收表
    Boolean addAcceptanceList(AcceptanceList acceptanceList);
    //修改验收表
    Boolean updateAcceptanceList(AcceptanceList acceptanceList);
    //删除验收表
    Boolean deleteAcceptanceList(Integer acceptId);
    //根据部门名称查询
    List<AcceptanceList> selectDepartment(String acceptDepartment);
    //根据申请人姓名查询
    List<AcceptanceList> selectAcceptPeople(String acceptPeople);

}
