package com.example.informationSystem.controller;

import com.example.informationSystem.entity.Attachment;
import com.example.informationSystem.service.AttachmentService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("/Attachment/Id/Info")
    public Result selectById(Integer noticeId) {
       return Result.success("查询成功", attachmentService.selectById(noticeId));
    }

    @RequestMapping("/Attachment/Insert")
    public Result addAttachment(Attachment attachment) {
        return Result.success("增加成功", attachmentService.addAttachment(attachment));
    }

    @RequestMapping("/Attachment/Update")
    public Result updateAttachment(Attachment attachment) {
        return Result.success("修改成功", attachmentService.updateAttachment(attachment));
    }

    @RequestMapping("/Attachment/Id/Delete")
    public Result deleteAttachment(Integer attachmentId) {
        return Result.success("删除成功", attachmentService.deleteAttachment(attachmentId));
    }
}
