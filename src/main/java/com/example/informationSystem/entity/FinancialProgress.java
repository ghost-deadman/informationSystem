package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 10:00
 */
@Data
@TableName(value = "financial_progress")
public class FinancialProgress {

    @TableId(type = IdType.ASSIGN_UUID)
    @TableField(value = "financial_progress_id")
    private String financialProgressId;

    /**
     * 0 未申请 1 审批中 2 已下拨 3 未通过
     */
    @TableField(value = "status")
    private Integer status;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}
