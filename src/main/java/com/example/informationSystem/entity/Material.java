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
public class Material {

  @TableId(value = "material_id",type = IdType.ASSIGN_ID)
  private String materialId;
  @TableField(value = "project_name")
  private long projectName;
  @TableField(value = "material_content")
  private String materialContent;
  @TableLogic(value = "0",delval = "1")
  @TableField(value = "deleted")
  private int deleted;

}
