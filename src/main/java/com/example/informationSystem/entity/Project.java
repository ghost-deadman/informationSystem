package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：ghost
 * @Date:  Created in 2022/9/15 9:22
 * @description: 项目实体
 */
@Data
@TableName(value = "project")
public class Project {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_id")
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
     * 项目内容表id
     */
    @TableField(value = "project_context_id")
    private String projectContextId;

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
     * 创建时间
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 执行状态 0默认 1执行中 2结题成功 3结题失败
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
