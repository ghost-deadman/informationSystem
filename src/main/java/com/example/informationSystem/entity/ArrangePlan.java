package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * @author ：zqy
 * @description: 项目资金使用记录
 */
@Data
@ToString
@TableName(value = "arrange_plan")
public class ArrangePlan implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "arrange_plan_id",type = IdType.ASSIGN_UUID)
    private String arrangePlanId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

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
     * 日期
     */
    @TableField(value = "date")
    private Date date;

    /**
     * 项目预算id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
}
