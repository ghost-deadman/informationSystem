package com.example.informationSystem.entity.DTO;

import com.example.informationSystem.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/27 9:34
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectDTO extends Project {

    /**
     * 项目文件对象
     */
    private List<ProjectFile> projectFileList;

    /**
     * 分类对象
     */
    private ProjectCategory projectCategory;

    /**
     * 审批意见
     */
    private ApprovalOpinion approvalOpinion;

    /**
     * 单位对象
     */
    private Unit unit;

    /**
     * 学科数据
     */
    private List<Subject> subjectList;

}
