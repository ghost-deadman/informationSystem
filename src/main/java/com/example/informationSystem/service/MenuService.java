package com.example.informationSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.informationSystem.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    /**
     * 根据角色获取菜单列表
     * @return 菜单列表
     */
    List<Menu> getMenusWithRole();

    /**
     * 获取当前用户的菜单列表
     * @return 菜单列表
     */
    List<Menu> getMenusByUserId();

}
