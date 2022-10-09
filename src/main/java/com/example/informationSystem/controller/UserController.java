package com.example.informationSystem.controller;

import com.example.informationSystem.entity.User;
import com.example.informationSystem.service.UserService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/9 15:06
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/admin/insert")
    public Result addUser(User user){

        if(userService.addUser(user)) {

            return Result.success("添加用户成功");

        }else{

            return Result.error("添加用户失败");

        }

    }

    @GetMapping("/user/password/update")
    public Result changePassword(String password){

        //TODO 获取用户id
        String userId = "123456";

        if(userService.updateUserPassword(userId,password)) {

            return Result.success("修改密码成功");

        }else{

            return Result.error("修改密码失败");

        }

    }

    @GetMapping("/user/info")
    public Result getUserInfo(){

        //TODO 获取用户id
        String userId = "123456";

        return Result.success("查询成功",userService.selectUserInfo(userId));

    }

    @GetMapping("/user/admin/delete")
    public Result deleteUserInfo(List<String> userIdList){

        if(userService.deleteUserBatch(userIdList)){

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

    @GetMapping("/user/admin/Page/List")
    public Result selectUserPage(long current,long size){

        return Result.success("查询成功",userService.selectUserPage(current,size));

    }


}
