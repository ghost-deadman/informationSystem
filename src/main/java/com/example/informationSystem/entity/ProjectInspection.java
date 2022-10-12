package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author pcdn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "project_inspection")
public class ProjectInspection {

  /**
   * 项目验收报告id
   */
  @TableId(value = "project_inspection_id",type = IdType.ASSIGN_UUID)
  private String projectInspectionId;

  /**
   * 项目id
   */
  @TableField(value = "project_id")
  private String projectId;

  /**
   * 报告类型 0 草稿 1 正文
   */
  @TableField(value = "type")
  private int type;

  /**
   * 用户id
   */
  @TableField(value = "user_id")
  private String userId;

  /**
   * 状态 0默认 1提交 2初审通过 3初审失败 4审批成功 5审批失败 6验收确认 7验收失败
   */
  @TableField(value = "status")
  private int status;

  /**
   * 审批意见id
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
   * 删除标识
   */
  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;


}
