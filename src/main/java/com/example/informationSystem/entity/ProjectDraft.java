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
 * @date ：Created in 2022/9/16 14:28
 */
@Data
@TableName(value = "project_draft")
public class ProjectDraft {
    /**
     * 主键
     */
    @TableId(value = "project_draft_id", type = IdType.ASSIGN_UUID)
    private String projectDraftId;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 项目类别id
     */
    @TableField(value = "project_category_id")
    private String projectCategoryId;

    /**
     * 项目负责人id
     */
    @TableField(value = "project_user_id")
    private String projectUserId;

    /**
     * 描述
     */
    @TableField(value = "project_describes")
    private String projectDescribes;

    /**
     * 名称
     */
    @TableField(value = "project_name")
    private String projectName;

    /**
     * 类型
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 单位id
     */
    @TableField(value = "unit_id")
    private String unitId;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
