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
     * 建设部门意见id
     */
    @TableField(value = "opinion_id")
    private String opinionId;

    /**
     * 描述
     */
    @TableField(value = "describes")
    private String describes;


    /**
     * 日期
     */
    @TableField(value = "date")
    private Date date;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    /**
     * 状态
     */
    @TableField(value = "status")
    private int status;

}
