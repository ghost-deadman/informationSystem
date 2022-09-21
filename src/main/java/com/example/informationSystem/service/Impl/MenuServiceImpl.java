package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.informationSystem.entity.Menu;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.mapper.MenuMapper;
import com.example.informationSystem.service.MenuService;
import com.example.informationSystem.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisCache redisCache;
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusByRole();
    }

    @Override
    public List<Menu> getMenusByUserId() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = principal.getId();
        List<Menu> menus =  redisCache.getCacheList("menu:" + id);
        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenusByUserId(id);
            redisCache.setCacheList("menu:" + id, menus);
        }
        return menus;
    }
}
