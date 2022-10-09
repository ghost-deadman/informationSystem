package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@TableName("sys_role")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role implements Serializable {
    private static final long serialVersionUID = -54979041104113736L;

    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标识")
    private String role_key;

    @ApiModelProperty(value = "部门id")
    private String unit_id;

    @ApiModelProperty(value = "是否启用 0停用 1正常")
    private Boolean enabled;

    @ApiModelProperty(value = "是否删除 0正常 1删除")
    private Boolean del_flag;

    @ApiModelProperty(value = "备注")
    private String remark;
}
