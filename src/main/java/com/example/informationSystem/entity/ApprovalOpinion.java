package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @TableId(value = "approval_opinion_id", type = IdType.ASSIGN_UUID)
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

}
