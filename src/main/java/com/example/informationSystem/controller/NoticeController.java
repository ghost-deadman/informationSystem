package com.example.informationSystem.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.service.NoticeService;
import com.example.informationSystem.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

   //条件分页查询
   @RequestMapping("/Notice/List")
   public  Result selectPage(IPage<Notice> page, @Param(Constants.WRAPPER) Wrapper<Notice> queryWrapper){
       return   Result.success(("查询成功"),noticeService.selectPage(page,queryWrapper));
   }

    @RequestMapping("/Notice/Id/info")
    public Result selectById(Integer noticeId){
        return Result.success("查询成功",noticeService.selectById(noticeId));
    }

    @RequestMapping("/Notice/Update")
    public Result updateById(Notice notice){
        return Result.success("修改成功",noticeService.updateById(notice));
    }

    @GetMapping("Notice/Insert")
    public  Result addNotice(Notice notice){
        return Result.success("增加成功",noticeService.addNotice(notice));
    }

    @GetMapping("Notice/Delete")
    public Result deleteNotice(Integer noticeId){
        return Result.success("删除成功",noticeService.deleteNotice(noticeId));
    }
}
