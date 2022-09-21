package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ：zqy
 * @date ：Created in 2022/9/14 15:28
 */
@Data
@TableName(value = "subject")
public class Subject {
    /**
     * 单位id
     */
    @TableId( type = IdType.ASSIGN_UUID)
    @TableField( value = "subject_id")
    private String subjectId;

    /**
     * 名称
     */
    @TableField( value = "name")
    private String name;

    /**
     * 删除标识
     */
    @TableLogic( value = "0", delval = "1")
    private Integer deleted;
}
