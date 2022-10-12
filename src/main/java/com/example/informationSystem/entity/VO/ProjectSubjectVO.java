package com.example.informationSystem.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProjectSubjectVO implements Serializable {
    /**
     * 学科名称
     */
    private String name;

    /**
     * 学科选择次数
     */
    private Integer value;
}
