package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 8:58
 */
@Data
public class Unit {


    /**
     * 单位id
     */
    @TableId( type = IdType.ASSIGN_UUID)
    @TableField( value = "unit_id")
    private String unitId;

    /**
     * 名称
     */
    @TableField( value = "name")
    private String name;

    /**
     * 删除标识
     */
    @TableLogic( value = "0", delval = "1")
    private Integer deleted;

}
