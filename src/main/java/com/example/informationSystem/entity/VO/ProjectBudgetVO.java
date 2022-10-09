package com.example.informationSystem.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "预算表单对象", description = "接收预算表单数据")
public class ProjectBudgetVO implements Serializable {

    @ApiModelProperty(value = "项目id", required = true)
    private String projectId;
    @ApiModelProperty(value = "金额", required = true)
    private String money;
    @ApiModelProperty(value = "具体描述", required = true)
    private String describes;

}
