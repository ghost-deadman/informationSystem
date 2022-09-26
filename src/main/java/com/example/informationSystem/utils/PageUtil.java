package com.example.informationSystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PageUtil<T> {
    private Integer currentPage;//当前页
    private Integer pageSize;//页面大小
    private Integer total;//总记录数
    private List<T> data;  //列表数据

}
