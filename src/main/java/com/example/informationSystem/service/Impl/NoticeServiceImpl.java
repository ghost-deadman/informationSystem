package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.mapper.NoticeMapper;
import com.example.informationSystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public IPage<Notice> selectAllByUserIdPage(int status,String informedPeople,long currentPage,long pageSize) {

        IPage<Notice> noticePage = new Page<>(currentPage,pageSize);

        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("notice_state",status);

        queryWrapper.eq("informed_people", informedPeople);

        return noticeMapper.selectPage(noticePage,queryWrapper);

    }

    @Override
    public int getNoticeByStatusAndUserCount(String userId, int status) {

        QueryWrapper<Notice> noticeQueryWrapper = new QueryWrapper<>();

        noticeQueryWrapper.eq("notice_state",status);

        noticeQueryWrapper.eq("informed_people",userId);

        return noticeMapper.selectCount(noticeQueryWrapper);

    }

    @Override
    public boolean deleteNoticeBatch(List<String> noticeIdList) {

        return noticeMapper.deleteBatchIds(noticeIdList) > 0;

    }

    @Override
    public boolean updateNoticeStatusById(String noticeId) {

        UpdateWrapper<Notice> noticeUpdateWrapper = new UpdateWrapper<>();

        noticeUpdateWrapper.set("notice_state",1);

        noticeUpdateWrapper.eq("notice_id",noticeId);

        return noticeMapper.update(null,noticeUpdateWrapper) > 0;

    }


}
