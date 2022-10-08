package com.example.informationSystem.entity;

//通知实体类

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * @author pcdn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

  /**
   * 主键
   */
  @TableId(value = "notice_id",type = IdType.ASSIGN_UUID)
  private String noticeId;

  /**
   * 通知名称 标题
   */
  @TableField(value = "notice_name")
  private String noticeName;

  /**
   * 通知内容
   */
  @TableField(value = "notice_content")
  private String noticeContent;

  /**
   * 附件数量 弃用
   */
  @TableField(value = "attachment_num")
  private long attachmentNum;

  /**
   * 发送人 系统
   */
  @TableField(value = "notice_person")
  private String noticePerson;

  /**
   * 接收人id
   */
  @TableField(value = "informed_people")
  private String informedPeople;

  /**
   * 通知创建时间
   */
  @TableField(value = "creation_time")
  private LocalDateTime creationTime;

  /**
   * 状态 0 默认未查看  1 已查看
   */
  @TableField(value = "notice_state")
  private int noticeState;

  /**
   * 删除标识
   */
  @TableField(value = "deleted")
  @TableLogic(value = "0",delval = "1")
  private int deleted;


}
