package com.example.informationSystem.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 *  资金使用记录日志vo
 */
@Data
@ToString
@ApiModel(value = "资金日志表", description = "资金使用日志")
public class ArrangePlanVO implements Serializable {
    @ApiModelProperty(value = "项目id", required = true)
    private String projectId;
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "金额", required = true)
    private String money;
    @ApiModelProperty(value = "日期", required = true)
    private Date date;
    @ApiModelProperty(value = "描述", required = true)
    private String describes;

}
