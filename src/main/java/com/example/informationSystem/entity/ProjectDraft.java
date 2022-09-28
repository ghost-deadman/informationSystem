package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ：zqy
 * @Date: ：Created in 2022/9/16 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "project_draft")
public class ProjectDraft {
    /**
     * 主键
     */
    @TableId( type = IdType.ASSIGN_UUID)
    @TableField(value = "project_draft_id")
    private String projectDraftId;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 项目负责人id
     */
    @TableField(value = "project_user_id")
    private String projectUserId;

    /**
     * 描述
     */
    @TableField(value = "describes")
    private String describes;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 类型
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 主学科id
     */
    @TableField(value = "subject_id")
    private String subjectId;

    /**
     * 副学科id
     */
    @TableField(value = "subject_second_id")
    private String subjectSecondId;

    /**
     * 单位id
     */
    @TableField(value = "unit_id")
    private String unitId;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
