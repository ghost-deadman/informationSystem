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
public class Inspectionreport {

  @TableId(type = IdType.ASSIGN_ID)
  @TableField(value = "inspection_id")
  private long inspectionId;
  @TableField(value = "project_name")
  private long projectName;
  @TableField(value = "mid_inspection")
  private String midInspection;
  @TableField(value = "year_inspection")
  private String yearInspection;
  @TableField(value = "concluding_inspection")
  private String concludingInspection;
  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;


}
