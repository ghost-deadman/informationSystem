package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**项目流程状态
 * @author ：zqy
 * @date ：Created in 2022/10/8 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectProcess {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_process_id")
    private String projectProcessId;

    /**
     *项目id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 日期
     */
    @TableField(value = "date")
    private LocalDateTime localDateTime;

    /**
     * 项目各阶段的状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 是否删除
     */
    @TableField(value = "deleted")
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
