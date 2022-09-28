package com.example.informationSystem.utils;

import java.lang.reflect.Field;

/**
 * 判断vo是否缺失值
 */
public class TestVo<T> {
    public boolean voIsFull(T t) {
        // voucher是目标对象
        try{
            //通过getDeclaredFields()方法获取对象类中的所有属性（含私有）
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                //设置允许通过反射访问私有变量
                field.setAccessible(true);
                //获取字段的值
                String value = field.get(t).toString();
                //获取字段属性名称
//                String name = field.getName();
                //其他自定义操作
                if (value == null || value.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception ex){
            //处理异常
        }
        return false;

    }
}
