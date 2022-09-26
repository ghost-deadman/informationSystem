package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "project_subject")
public class ProjectSubject {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_subject_id")
    private String projectSubjectId;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 学科id
     */
    @TableField(value = "subject_id")
    private String subjectId;

}
