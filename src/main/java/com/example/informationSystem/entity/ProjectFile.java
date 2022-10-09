package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 16:30
 */
@Data
@TableName(value = "project_file")
public class ProjectFile {

    /**
     * 项目文件材料主键
     */
    @TableId(value = "project_file_id",type = IdType.ASSIGN_UUID)
    private String projectFileId;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 文档类型 0 申报书草稿 1 项目申报书 2 项目任务书 3 项目正文 4 项目预算信息 5 项目设备信息 6 项目年度验收报告 7 项目中期验收报告 8 项目完结验收报告
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 文件路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 创建时间
     */
    @TableField(value = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    /**
     * 文件名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 删除标识
     */
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
