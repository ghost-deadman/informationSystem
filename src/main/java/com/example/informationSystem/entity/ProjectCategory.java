package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 15:56
 */
@Data
@TableName(value = "project_category")
public class ProjectCategory {

    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_category_id")
    private String projectCategoryId;

    @TableField(value = "name")
    private String name;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
