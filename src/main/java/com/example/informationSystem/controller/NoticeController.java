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

   //根据收件人姓名和状态查询
   @RequestMapping("/Notice/User/List")
   public  Result selectName(String informedPeople,int noticeState){
       return   Result.success(("查询成功"),noticeService.selectName(informedPeople,noticeState));
   }

    @RequestMapping("/Notice/Id/info")
    public Result selectById(Integer noticeId){
        return Result.success("查询成功",noticeService.selectById(noticeId));
    }

    @RequestMapping("/Notice/Update")
    public Result updateById(Notice notice){
        if(noticeService.updateById(notice)){
            return Result.success("修改成功");
        }
        else
            return Result.error("修改失败");
    }

    @GetMapping("/Notice/Insert")
    public  Result addNotice(Notice notice){
       if(noticeService.addNotice(notice)){
           return Result.success("增加成功");
       }
       else
           return Result.error("增加失败");

    }

    @GetMapping("/Notice/Delete")
    public Result deleteNotice(Integer noticeId){
       if(noticeService.deleteNotice(noticeId)){
           return Result.success("删除成功");
       }
       else
           return Result.error("删除失败");

    }
}
