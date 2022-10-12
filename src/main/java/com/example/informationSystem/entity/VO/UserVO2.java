package com.example.informationSystem.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "注册用户信息VO")
public class UserVO2 {
    @ApiModelProperty(value = "用户账号")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "用户号码")
    private String phoneNumber;
    @ApiModelProperty(value = "用户性别")
    private String sex;
    @ApiModelProperty(value = "用户角色")
    private List<String> role;
    @ApiModelProperty(value = "是否启用")
    private Boolean enable;

}
