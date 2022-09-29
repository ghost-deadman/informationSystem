package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditopinion {

  @TableId(type = IdType.ASSIGN_ID)
  @TableField(value = "audit_id")
  private long auditId;
  @TableField(value = "project_name")
  private long projectName;
  @TableField(value = "mid_opinion")
  private String midOpinion;
  @TableField(value = "year_opinion")
  private String yearOpinion;
  @TableField(value = "acceptance_opinion")
  private String acceptanceOpinion;
  @TableField(value = "audit_people")
  private String auditPeople;
  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;
}
