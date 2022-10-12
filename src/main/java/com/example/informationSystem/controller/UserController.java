package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.UserDTO;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.VO.UserVO2;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.service.UserService;
import com.example.informationSystem.utils.Result;
import com.example.informationSystem.utils.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/9 15:06
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;


    @PostMapping("/user/admin/insert")
    public Result addUser(UserVO2 user){
        TestVo<UserVO2> testVo = new TestVo<>();
        boolean b = testVo.voIsFull(user);
        if (!b) {
            return Result.error("信息不全！请填完！");
        } else {
            if(userService.addUser(user)) {

                return Result.success("添加用户成功");

            }else{

                return Result.error("添加用户失败");

            }
        }

    }

    @PostMapping("/user/password/update")
    public Result changePassword(String oldPassword,String newPassword){

        //获取用户id
        String userId = loginService.getUserId();

        if(userService.updateUserPassword(userId,oldPassword,newPassword)) {

            return Result.success("修改密码成功");

        }else{

            return Result.error("修改密码失败");

        }

    }

    @GetMapping("/user/buildAdmin/userList")
    public Result getUsersOfUnit(Integer current, Integer size) {
        String unitId = loginService.getUserUnitId();
        Page<UserDTO> users = userService.getUsersByUnit(current, size, unitId);
        return Result.success("查询成功", users);
    }

    @GetMapping("/user/Overall/userList")
    public Result getUsersOfUnit(Integer current, Integer size, String unitId) {
        Page<UserDTO> users = userService.getUsersByUnit(current, size, unitId);
        return Result.success("查询成功", users);
    }

    @GetMapping("/user/admin/enable")
    public Result enableUserInfo(String userId){

        if(userService.enableUser(userId)){

            return Result.success("删除成功");

        }else{

            return Result.error("删除失败");

        }

    }

    @GetMapping("/user/admin/disEnable")
    public Result unEnableUserInfo(String userId){

        if(userService.unEnableUser(userId)){

            return Result.success("删除成功");

        }else{

            return Result.error("删除失败");

        }

    }


    @PostMapping("/user/admin/update")
    public Result updateUserInfo(User user){

        if(userService.updateUserInfo(user)){

            return Result.success("修改成功");

        }else{

            return Result.error("修改失败");

        }

    }


    @GetMapping("/Build/Admin/Page/List")
    public Result selectUserPageByUnit(long current,long size){

        String unitId = loginService.getUserUnitId();

        String userId = loginService.getUserId();

        return Result.success("查询成功",userService.selectUserPageByUnit(unitId,userId,current,size));

    }


}
