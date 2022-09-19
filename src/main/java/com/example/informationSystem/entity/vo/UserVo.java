package com.example.informationSystem.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author by zzx
 * @description: 用户登录实体类
 * @Date: Created in 09:07 on 2022/9/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserLogin对象",description = "接受用户登录表单数据")
public class UserVo {
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
    @ApiModelProperty(value = "所属部门",required = true)
    private String department;
    @ApiModelProperty(value = "登录类型",required = true)
    private String type;

}

