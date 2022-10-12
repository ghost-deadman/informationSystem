package com.example.informationSystem.entity.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class UserDTO{
    private String id;
    private String userName;
    private String nickName;
    private String sex;
    private String email;
    private String createName;
    private LocalDateTime createTime;
    @TableField(exist = false)
    private List<RoleDTO> myRoles;
    private Boolean enabled;
}
