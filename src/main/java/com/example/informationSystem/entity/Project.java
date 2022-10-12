package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 9:22
 */
@Data
@TableName(value = "project")
public class Project {

    /**
     * 主键
     */
    @TableId(value = "project_id",type = IdType.ASSIGN_UUID)
    private String projectId;

    /**
     * 项目预算表id
     */
    @TableField(value = "project_budget_id")
    private String projectBudgetId;

    /**
     * 项目类别i表d
     */
    @TableField(value = "project_category_id")
    private String projectCategoryId;

    /**
     * 财务进度表id
     */
    @TableField(value = "financial_progress_id")
    private String financialProgressId;

    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    private String projectName;

    /**
     * 项目概述
     */
    @TableField(value = "project_describes")
    private String projectDescribes;

    /**
     * 项目类型 0 理论 1 实体
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 项目负责人id
      */
    @TableField(value = "project_user_id")
    private String projectUserId;

    /**
     * 单位id
     */
    @TableField(value = "unit_id")
    private String unitId;

    /**
     * 项目立项意见id
     */
    @TableField(value = "approval_opinion_id")
    private String approvalOpinionId;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    /**
     * 执行状态 0默认 1执行中 2结题中 3结题成功 3结题失败
     */
    @TableField(value = "execute_status")
    private Integer executeStatus;

    /**
     * 创建状态0创建 1申请中 2申请失败 3申请成功 4审批成功 5审批失败 6立项成功 7立项失败
     */
    @TableField(value = "create_status")
    private Integer createStatus;

    /**
     * 删除标识 0默认 1删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
