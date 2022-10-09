package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Specialist;
import com.example.informationSystem.entity.Unit;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 16:13
 */
public interface SpecialistService {

    /**
     * 添加专家
     * @param specialist 专家对象
     * @return 是否成功
     */
    boolean addSpecialist(Specialist specialist);

    /**
     * 删除专家
     * @param id 专家id
     * @return 是否成功
     */
    boolean deleteSpecialistById(String id);

    /**
     * 更新专家
     * @param specialist 专家数据
     * @return 是否成功
     */
    boolean updateSpecialistById(Specialist specialist);

    /**
     * 查询专家数据
     * @param id 专家id
     * @return 专家对象
     */
    Specialist selectSpecialistById(String id);

    /**
     * 查询所有专家数据
     * @return 专家对象数组
     */
    List<Specialist> selectAll();

    /**
     * 分页查询
     * @param current 页数
     * @param size 每页数据条数
     * @return 分页对象
     */
     IPage<Specialist> selectAll(long current, long size);
}
