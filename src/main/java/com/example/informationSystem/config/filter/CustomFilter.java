package com.example.informationSystem.config.filter;


import com.example.informationSystem.entity.Menu;
import com.example.informationSystem.entity.Role;
import com.example.informationSystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;


/**
 *  @author zzx
 *  @description: 权限控制-根据请求url分析请求所需角色
 *  @since 1.0.0
 */

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    private static List<Menu> menus;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求url
        String url = ((FilterInvocation) object).getRequestUrl();
        if (menus == null) {
            menus = menuService.getMenusWithRole();
        }
        if (menus != null) {
            for (Menu menu : menus) {
                //判断url与角色是否匹配
                if (antPathMatcher.match(menu.getUrl(), url)) {
                    String[] strings = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                    return SecurityConfig.createList(strings);
                }
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
