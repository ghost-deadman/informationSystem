package com.example.informationSystem.entity.DTO;

import com.example.informationSystem.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/8 14:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectInspectionDTO extends ProjectInspection {

    /**
     * 项目文件对象
     */
    private List<ProjectFile> projectFileList;


    /**
     * 审批意见
     */
    private ApprovalOpinion approvalOpinion;

    /**
     * 项目名
     */
    private String projectName;

}
