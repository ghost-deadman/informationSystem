package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author ：zqy
 * @date ：Created in 2022/9/23 14:28
 */
@Data
@TableName(value = "project_budget")
public class ProjectBudget {
    /**
     * 主键
     */
    @TableField(value = "project_budget_id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String projectBudgetId;

    /**
     * 总金额
     */
    @TableField(value = "money")
    private String money;

    /**
     * 建设单位负责人是否审核通过
     */
    @TableField(value = "if_construction_pass")
    private int ifConstructionPass;

    /**
     * 建设单位负责人意见
     */
    @TableField(value = "construction_opinion")
    private String constructionOpinion;

    /**
     * 归口部门管理员是否审核通过
     */
    @TableField(value = "if_relevant_pass")
    private int ifRelevantPass;

    /**
     * 归口部门管理员审核意见
     */
    @TableField(value = "relevant_opinion")
    private String relevantOpinion;

    @TableField(value = "date")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;
    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
