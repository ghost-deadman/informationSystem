package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：zqy
 * @date ：Created in 2022/9/19 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCategory {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_category_id")
    private String projectCategoryId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
