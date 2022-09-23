package com.example.informationSystem.controller;

import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.vo.UserVo;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.utils.RedisCache;
import com.example.informationSystem.utils.result.Result;
import com.example.informationSystem.utils.yzm.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "用户统一登录")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisCache redisCache;

    @ApiOperation(value = "登录验证，返回token")
    @PostMapping("/user/login")
    public Result login(@RequestBody UserVo user,HttpServletRequest request){
        return loginService.login(user, request);
    }

    /**
     * 退出登录
     * @return 退出结果
     */
    @ApiOperation(value = "用户登出，需携带有效token")
    @GetMapping("/user/logout")
    public Result logout(){
        return loginService.logout();
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/user/info")
    public Result getUserInfo(Principal principal) {
        if (principal == null) {
            return Result.error("错误！请重新登录");
        } else {
            String userName = principal.getName();
            System.out.println(userName + "123");
            if (userName == null) {
                return Result.error("错误！");
            }
            User userInfo = loginService.getUserInfo(userName);
            // 添加角色信息
            userInfo.setRoles(loginService.getRoles(userInfo.getId()));
            return Result.success(userInfo);
        }
    }

    /**
     * 获取验证码
     *
//     * @param request 前端请求
//     * @param response  图片
     * @author zzx
     * @date 2022/5/21 14:36
     */


    @ApiOperation(value = "获取验证码",produces = "image/jpeg")
    @GetMapping(value = "/yzm")
    public void yzm(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println("验证码："+verifyCode);
        String imgUUID = request.getRemoteAddr();
        redisCache.setCacheObject(imgUUID, verifyCode, 60 * 2, TimeUnit.SECONDS);
//        HttpSession session = request.getSession();
//        session.removeAttribute("captcha");
//        session.setAttribute("captcha", verifyCode);

//        String captcha = (String) session.getAttribute("captcha");
        System.out.println("session1: " + imgUUID);

        // 生成图片
        int w = 100, h = 40;
        OutputStream out = response.getOutputStream();
        VerifyCodeUtils.outputImage(w, h, out, verifyCode);

    }

/*
    // 获取验证码
    @GetMapping("/yzm")
    @ResponseBody
    public Result getCaptcha() {
        //画图工具类
        CaptchaUtil imageCode = new CaptchaUtil();
        // 获取验证码对应的 base64  编码
        String base64 = CaptchaUtil.getBase64(imageCode.getImage());

        // 获取对应的 验证码 code
        String code = imageCode.getCode();

        // 生成 UUID
        String imgUUID = UUID.randomUUID().toString();

        // 封装 获取的 验证码相关的数据 到 验证码对象中，并响应
        ImgResult imgResult = new ImgResult();
        imgResult.setImgUUID(imgUUID);
        imgResult.setImg(base64);
        imgResult.setCode(code);
        System.out.println("code1: " + code);
        // 将验证码的信息保存到 redis中,并设置 有效时间！
        redisCache.setCacheObject(imgUUID, code, 60 * 2, TimeUnit.SECONDS);
//        captchaCache.setEx(imgUUID, 60 * 2, code);
        // 将封装好的验证码对象响应给前端
        return Result.success(imgResult);

    }
*/
}

