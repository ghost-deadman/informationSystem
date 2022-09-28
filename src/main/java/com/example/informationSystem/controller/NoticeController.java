package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.service.NoticeService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author pcdn
 */
@RestController
public class NoticeController {

    private final static int UNREAD = 0;

    private final static int READ = 1;

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/Notice/User/Unread/List")
    public Result selectUnread(long currentPage ,long pageSize) {

        //token 拿用户id
        String userId = "123456";



        return Result.success(("查询成功"), noticeService.selectAllByUserIdPage(UNREAD,userId,currentPage,pageSize));

    }

    @RequestMapping("/Notice/User/Read/List")
    public Result selectRead(long currentPage ,long pageSize) {

        //token 拿用户id
        String userId = "123456";

        return Result.success(("查询成功"), noticeService.selectAllByUserIdPage(READ,userId,currentPage,pageSize));

    }

    @RequestMapping("/Notice/Id/info")
    public Result selectById(Integer noticeId) {
        return Result.success("查询成功", noticeService.selectById(noticeId));
    }

    @RequestMapping("/Notice/Update")
    public Result updateById(Notice notice) {
        if (noticeService.updateById(notice)) {

            return Result.success("修改成功");

        } else {

            return Result.error("修改失败");

        }
    }

    @GetMapping("/Notice/Insert")
    public Result addNotice(Notice notice) {

        if (noticeService.addNotice(notice)) {

            return Result.success("增加成功");

        } else {

            return Result.error("增加失败");

        }

    }

    @GetMapping("/Notice/Id/Delete")
    public Result deleteNotice(Integer noticeId) {

        if(noticeService.deleteNotice(noticeId)){

            return Result.success("删除成功");

        }else{

            return Result.error("删除失败");

        }

    }
}
