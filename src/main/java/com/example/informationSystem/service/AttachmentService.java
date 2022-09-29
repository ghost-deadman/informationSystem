package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.informationSystem.entity.Attachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttachmentService {
    //通过通知id查看附件
    List<Attachment> selectById(Integer noticeId);
    //增加附件
    int addAttachment(Attachment attachment);
    //修改附件
    int updateAttachment(Attachment attachment);
    //删除附件
    int deleteAttachment(Integer attachmentId);
    //删除通知的所有附件
    int deleteAll(Integer noticeId);
}
