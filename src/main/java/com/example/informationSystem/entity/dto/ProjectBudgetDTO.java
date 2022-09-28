package com.example.informationSystem.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author ：zqy
 * @date ：Created in 2022/9/26 14:28
 */

/**
 * 进行项目预算分页参数的类，包括按时间查询、按当前页、页数查询、已审核、未审核查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectBudgetDTO implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "project_budget_id")
    private String projectBudgetId;
    /**
     * 项目id
     */
    @TableField(value = "project_name")
    private String projectName;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "money")
    private String money;

    @TableField(value = "unit_id")
    private String unitId;

    @TableField(value = "unit_name")
    private String unitName;

    @TableField(value = "opinionId")
    private String opinionId;

    @TableField(value = "date")
    private Date date;

    @TableField(value = "describes")
    private String describes;
}
