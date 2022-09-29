package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.informationSystem.entity.Acceptancelist;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AcceptancelistService {

    //查询所有验收表
    List<Acceptancelist> getAll();
    //根据id查询验收表
    Acceptancelist selectById(Integer acceptId);
    //增加验收表
    Boolean addAcceptancelist(Acceptancelist acceptancelist);
    //修改验收表
    Boolean updateAcceptancelist(Acceptancelist acceptancelist);
    //删除验收表
    Boolean deleteAcceptancelist(Integer acceptId);
    //根据部门名称查询
    List<Acceptancelist> selectDepartment(String acceptDepartment);
    //根据申请人姓名查询
    List<Acceptancelist> selectAcceptpeople(String acceptPeople);

}
