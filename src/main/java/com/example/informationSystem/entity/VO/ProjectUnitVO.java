package com.example.informationSystem.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectUnitVO {
    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位选择次数
     */
    private Integer value;
}
