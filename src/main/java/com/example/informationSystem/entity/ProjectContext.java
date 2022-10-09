package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 10:09
 */
@Data
@TableName(value = "project_context")
public class ProjectContext {

    /**
     * 主键
     */
    @TableId(value = "project_context_id",type = IdType.ASSIGN_UUID)
    private String projectContextId;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 概述
     */
    @TableField(value = "describes")
    private String describes;

    /**
     * 删除标识
     */
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
