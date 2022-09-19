package com.example.informationSystem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单表(Menu)实体类
 *
 * @author zzx
 * @since 2022-9-18 15:30:08
 */
@TableName(value="sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
    private static final long serialVersionUID = -54979041104113736L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;
    /**
     * 菜单名
     */
    @ApiModelProperty(value = "菜单名")
    private String menuName;
    /**
     * 路由地址
     */
    @ApiModelProperty(value = "路由path")
    private String path;
    /**
     * 组件路径
     */
    @ApiModelProperty(value = "组件名")
    private String component;
    /**
     * 保持激活（0否 1是）
     */
    @ApiModelProperty(value = "保持激活")
    private Boolean keepAlive;
    /**
     * 是否启用（1正常 0停用）
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean enable;
    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    private String perms;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parentId;
    /**
     * 是否删除（0未删除 1已删除）
     */
    @ApiModelProperty(value = "是否删除")
    private boolean delFlag;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<Menu> children;

}
