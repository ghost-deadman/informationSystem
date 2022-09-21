package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/20 14:58
 */
@Data
public class ApprovalOpinion {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "approval_opinion_id")
    private String approvalOpinionId;

    /**
     * 内容
     */
    @TableField(value = "context")
    private String context;

    /**
     * 编写者id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 审批时间
     */
    @TableField(value = "date")
    private LocalDateTime date;

}
