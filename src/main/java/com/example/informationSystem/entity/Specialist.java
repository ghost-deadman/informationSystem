package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Value;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 16:07
 */
@Data
@TableName(value = "specialist")
public class Specialist {

    /**
     * 专家id
     */
    @TableId(value = "specialist_id",type = IdType.ASSIGN_UUID)
    private String specialistId;

    /**
     * 专业
     */
    @TableField(value = "speciality")
    private String speciality;

    /**
     * 学校
     */
    @TableField(value = "school")
    private String school;

    /**
     * 职称
     */
    @TableField(value = "rank")
    private String rank;

    /**
     * 用户id外键
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 删除标识 默认0 删除1
     */
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
