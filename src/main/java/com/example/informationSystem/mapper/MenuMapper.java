package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户ID查询菜单列表
     * @param id 用户id
     * @return 菜单
     */
    List<Menu> getMenusByUserId(Long id);

    /**
     * 根据角色获取菜单列表
     * @return 菜单
     */
    List<Menu> getMenusByRole();

    /**
     * 查询所有菜单
     * @return 菜单
     */
    List<Menu> queryAllMenus();
}
