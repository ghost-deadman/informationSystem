package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Acceptancelist;
import com.example.informationSystem.mapper.NoticeMapper;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getAll() {
        return noticeMapper.selectList(null);
    }

    @Override
    public List<Notice> selectById(Integer noticeId) {
        return (List<Notice>) noticeMapper.selectById(noticeId);
    }




//    @Override
//    public List<Map<String, Object>> selectMaps(Wrapper<Notice> queryWrapper) {
//        return null;
//    }


    @Override
    public int updateById(Notice noticeId) {
        return noticeMapper.updateById(noticeId);
    }


    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }

    @Override
    public int deleteNotice(Integer noticeId) {
        return noticeMapper.deleteById(noticeId);
    }

    @Override
    public IPage<Notice> selectPage(IPage<Notice> page, Wrapper<Notice> queryWrapper) {
        return noticeMapper.selectPage(page,queryWrapper);
    }



}
