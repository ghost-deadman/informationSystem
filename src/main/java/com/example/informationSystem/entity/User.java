package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 用户表(User)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "sys_user")
public class User implements Serializable, UserDetails {
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
     * 账号状态（1正常 0停用）
     */
    @Getter(AccessLevel.NONE)
    @ApiModelProperty(value = "是否启用，1正常 0停用")
    @TableField("ENABLED")
    private Boolean enabled;
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

    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<Role> roles;

    @ApiModelProperty(value = "认证")
//    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_key()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

