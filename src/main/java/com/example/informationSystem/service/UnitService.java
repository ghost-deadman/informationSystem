package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Unit;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 9:03
 */
public interface UnitService {

    /**
     * 添加单位
     * @param unit 单位对象
     * @return 是否成功
     */
    boolean addUnit(Unit unit);

    /**
     * 删除单位
     * @param id 单位id
     * @return 是否成功
     */
    boolean deleteUnit(String id);

    /**
     * 更新单位
     * @param unit 单位数据
     * @return 是否成功
     */
    boolean updateUnit(Unit unit);

    /**
     * 查询单位数据
     * @param id 单位id
     * @return 单位对象
     */
    Unit selectUnit(String id);

    /**
     * 查询所有单位数据
     * @return 单位对象数组
     */
    List<Unit> selectAll();

    /**
     * 分页查询
     * @param current 页数
     * @param size 每页条数
     * @return 分页对象
     */
    IPage<Unit> selectAll(long current, long size);
}
