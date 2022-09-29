package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.Material;
import com.example.informationSystem.mapper.MaterialMapper;
import com.example.informationSystem.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public List<Material> getAll() {
        return materialMapper.selectList(null);
    }

    @Override
    public Material selectById(Integer materialId) {
        return materialMapper.selectById(materialId);
    }

    @Override
    public Boolean addMaterial(Material material) {
        materialMapper.insert(material);
        return true;
    }

    @Override
    public Boolean updateMaterial(Material material) {
         materialMapper.updateById(material);
         return true;
    }

    @Override
    public Boolean deleteMaterial(Integer materialId) {
       materialMapper.deleteById(materialId);
       return true;
    }
}
