package com.example.informationSystem.service;


import com.example.informationSystem.entity.Material;

import java.util.List;

public interface MaterialService {
    //查询所有验收材料
    List<Material> getAll();
    //根据项目id查询验收材料
    Material selectById(Integer materialId);
    //增加验收材料
    Boolean addMaterial(Material material);
    //修改验收材料
    Boolean updateMaterial(Material material);
    //删除验收材料
    Boolean deleteMaterial(Integer materialId);
}
