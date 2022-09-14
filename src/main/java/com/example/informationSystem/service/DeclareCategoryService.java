package com.example.informationSystem.service;

import com.example.informationSystem.entity.DeclareCategory;
import com.example.informationSystem.mapper.DeclareCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 16:01
 */
public interface DeclareCategoryService {

    /**
     * 添加项目类别数据
     * @param declareCategory 项目类别对象
     * @return 是否成功
     */
    boolean addDeclareCategory(DeclareCategory declareCategory);

    /**
     * 更新项目类别数据
     * @param declareCategory 项目类别数据对象
     * @return 是否成功
     */
    boolean updateDeclareCategory(DeclareCategory declareCategory);

    /**
     * 删除项目类别数据
     * @param id 项目类别id
     * @return 是否成功
     */
    boolean deleteDeclareCategoryById(String id);

    /**
     * 查询项目类别
     * @param id 项目类别id
     * @return 项目类别对象
     */
    DeclareCategory selectDeclareCategoryById(String id);

    /**
     * 查询所有项目类别数据
     * @return 项目类别数组对象
     */
    List<DeclareCategory> selectAll();

}
