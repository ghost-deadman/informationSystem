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
    public Notice selectById(Integer noticeId) {

        return noticeMapper.selectById(noticeId);
    }



    @Override
    public boolean updateById(Notice noticeId) {
        noticeMapper.updateById(noticeId);
        return true;
    }


    @Override
    public boolean addNotice(Notice notice) {
        noticeMapper.insert(notice);
        return true;
    }

    @Override
    public boolean deleteNotice(Integer noticeId) {
        noticeMapper.deleteById(noticeId);
        return true;
    }

    @Override
    public List<Notice> selectName(String informedPeople, int noticeState) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("informed_people", informedPeople);//格式：(字段，值）
        queryWrapper.eq("notice_state",noticeState);
        queryWrapper.select("notice_id","notice_name","notice_person","creation_time");
        return noticeMapper.selectList(queryWrapper);
    }




}
