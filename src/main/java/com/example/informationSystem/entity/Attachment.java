package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//通知附件实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

  @TableId(type = IdType.ASSIGN_ID)
  @TableField(value = "attachment_id")
  private String attachmentId;
  @TableField(value = "attachment_content")
  private String attachmentContent;
  @TableField(value = "attachment_name")
  private String attachmentName;
  @TableField(value = "notice_id")
  private long noticeId;



}
