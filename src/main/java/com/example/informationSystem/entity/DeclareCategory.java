package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 15:56
 */
@Data
public class DeclareCategory {

    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "declare_category_id")
    private String declareCategoryId;

    @TableField(value = "name")
    private String name;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
