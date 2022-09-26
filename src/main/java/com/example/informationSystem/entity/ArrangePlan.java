package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ：zqy
 * @date ：Created in 2022/9/23 14:28
 */
@Data
@TableName(value = "arrange_plan")
public class ArrangePlan implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "arrange_plan_id")
    private String arrangePlanId;

    /**
     * 金额
     */
    @TableField(value = "money")
    private String money;

    /**
     * 描述
     */
    @TableField(value = "describes")
    private String describes;

    /**
     * 负责人id
     */
    @TableField(value = "principal_id")
    private String principalId;

    /**
     *批准人id
     */
    @TableField(value = "approver_id")
    private String approverId;

    /**
     * 日期
     */
    @TableField(value = "date")
    private Date date;

    /**
     * 项目预算id
     */
    @TableField(value = "project_budget_id")
    private String projectBudgetId;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;


}
