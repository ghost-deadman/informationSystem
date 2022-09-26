package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ：zqy
 * @date ：Created in 2022/9/14 17:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialist {
    /**
     * 主键
     */
    @TableField(value = "specialist_id")
    @TableId(type = IdType.ASSIGN_UUID)
    private String specialistId;

    /**
     * 专业
     */
    @TableField(value = "specialty")
    private String specialty;

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
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    private Integer deleted;


}
