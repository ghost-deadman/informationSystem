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
public class AcceptanceList {

  @TableId(value = "accept_id",type = IdType.ASSIGN_ID)
  private String acceptId;

  @TableField(value = "project_name")
  private String projectName;

  @TableField(value = "project_execution")
  private String projectExecution;

  @TableField(value = "project_results")
  private String projectResults;

  @TableField(value = "accept_department")
  private String acceptDepartment;

  @TableField(value = "accept_people")
  private String acceptPeople;

  @TableField(value = "check_people")
  private String checkPeople;

  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;


}
