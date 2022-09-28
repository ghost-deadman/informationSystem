package com.example.informationSystem.entity.VO;

import com.example.informationSystem.entity.Project;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/19 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectVO extends Project {

    /**
     * 学科数组
     */
    private List<String> subjectIdList;


}
