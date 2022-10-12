package com.example.informationSystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@TableName(value = "sys_user_role")
public class UserRole {
    private String userId;
    public String roleId;

}
