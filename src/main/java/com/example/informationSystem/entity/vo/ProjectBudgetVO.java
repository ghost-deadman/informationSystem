package com.example.informationSystem.entity.vo;

import com.example.informationSystem.entity.ProjectBudget;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：zqy
 * @date ：Created in 2022/9/26 14:28
 */

/**
 * 进行项目预算分页参数的类，包括按时间查询、按当前页、页数查询、已审核、未审核查询
 */
@Data
public class ProjectBudgetVO extends ProjectBudget implements Serializable {
//    /**
//     *日期
//     */
//    private Date date;

//    /**
//     * 是否查看建设单位已审核
//     */
//    private Integer ifConstructionPass;
//
//    /**
//     * 是否查看归口部门已审核
//     */
//
//    private Integer ifRelevantPass;
//
//    /**
//     * 当前页
//     */
//    private Integer currentPage;
//
//    /**
//     * 页数
//     */
//    private Integer pageSize;

    /**
     *创建人
     */
    private String userId;

    /**
     * 项目id
     */
    private String projectId;
}
