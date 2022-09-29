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


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

  @TableId(type = IdType.ASSIGN_UUID)
  @TableField(value = "notice_id")
  private String noticeId;
  @TableField(value = "notice_name")
  private String noticeName;
  @TableField(value = "notice_content")
  private String noticeContent;
  @TableField(value = "attachment_num")
  private long attachmentNum;
  @TableField(value = "notice_person")
  private String noticePerson;
  @TableField(value = "informed_people")
  private String informedPeople;
  @TableField(value = "creation_time")
  private LocalDateTime creationTime;
  /**
   * 0默认未查看
   * 1已查看
   */
  @TableField(value = "notice_state")
  private int noticeState;

  /**
   * 0默认
   * 1删除
   */
  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;

}
