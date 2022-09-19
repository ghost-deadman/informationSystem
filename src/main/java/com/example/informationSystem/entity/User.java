package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表(User)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户账号")
    @TableField("USER_NAME")
    private String userName;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称")
    @TableField("NICK_NAME")
    private String nickName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "是否启用，1正常0停用")
    @TableField("ENABLE")
    private Boolean enable;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    @TableField("EMAIL")
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "电话号码")
    @TableField("PHONENUMBER")
    private String phonenumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    private String sex;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @TableField("AVATAR")
    private String avatar;
    /**
     * 用户类型（0管理员，1普通用户）
     */
    @ApiModelProperty(value = "用户类型 0管理员1用户")
    @TableField("USER_TYPE")
    private String userType;
    /**
     * 创建人的用户id
     */
    @ApiModelProperty(value = "创建者id")
    @TableField("CREATE_BY")
    private Long createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    @TableField("UPDATE_BY")
    private Long updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    @ApiModelProperty(value = "是否删除 0未删除 1已删除")
    @TableField("DEL_FLAG")
    private Boolean delFlag;
}

