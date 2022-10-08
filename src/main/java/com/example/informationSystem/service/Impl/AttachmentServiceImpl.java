package com.example.informationSystem.service.Impl;

import com.example.informationSystem.mapper.AttachmentMapper;
import com.example.informationSystem.entity.Attachment;
import com.example.informationSystem.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentMapper attachmentMapper;
    @Override
    public List<Attachment> selectById(Integer noticeId) {
        return (List<Attachment>) attachmentMapper.selectById(noticeId);
    }

    @Override
    public int addAttachment(Attachment attachment) {
        return attachmentMapper.insert(attachment);
    }

    @Override
    public int updateAttachment(Attachment attachmentId) {
        return attachmentMapper.updateById(attachmentId);
    }

    @Override
    public int deleteAttachment(Integer attachmentId) {

        return attachmentMapper.deleteById(attachmentId);
    }

    @Override
    public int deleteAll(Integer noticeId) {

        return attachmentMapper.deleteById(noticeId);
    }
}
