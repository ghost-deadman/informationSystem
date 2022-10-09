package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.service.NoticeService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author pcdn
 */
@RestController
public class NoticeController {

    private final static int UNREAD = 0;

    private final static int READ = 1;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private LoginService loginService;


    @GetMapping("/Notice/UnRead/List")
    public Result selectUnread(long currentPage ,long pageSize) {

        //token 拿用户id
        String userId = loginService.getUserId();

        return Result.success(("查询成功"), noticeService.selectAllByUserIdPage(UNREAD,userId,currentPage,pageSize));

    }

    @GetMapping("/Notice/Read/List")
    public Result selectRead(long currentPage ,long pageSize) {

        //token 拿用户id
        String userId = loginService.getUserId();

        return Result.success(("查询成功"), noticeService.selectAllByUserIdPage(READ,userId,currentPage,pageSize));

    }

    @GetMapping("/Notice/Id/info")
    public Result selectById(Integer noticeId) {
        return Result.success("查询成功", noticeService.selectById(noticeId));
    }

    @GetMapping("/Notice/Id/Update")
    public Result updateNoticeStatusById(String noticeId) {

        if (noticeService.updateNoticeStatusById(noticeId)) {

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

    @GetMapping("/Notice/UnRead/Count")
    public Result getUnReadNoticeCount(){

        //token 那 用户id
        String userId = loginService.getUserId();

        return Result.success(noticeService.getNoticeByStatusAndUserCount(userId,UNREAD));

    }

    @GetMapping("/Notice/Read/Count")
    public Result getReadNoticeCount(){

        //token 那 用户id
        String userId = loginService.getUserId();

        return Result.success(noticeService.getNoticeByStatusAndUserCount(userId,READ));

    }

    @GetMapping("/Notice/Batch/Delete")
    public Result deleteNoticeBatch(List<String> noticeIdList){

        return Result.success(noticeService.deleteNoticeBatch(noticeIdList));

    }

}
