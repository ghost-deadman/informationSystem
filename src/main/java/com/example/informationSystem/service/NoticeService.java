package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Acceptancelist;
import com.example.informationSystem.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    //查询所有通知数据
    List<Notice> getAll();
    //根据id查询数据
    List<Notice> selectById(Integer notice_id);

    //根据通知id修改通知内容
    int updateById(Notice notice);

    //增加一个通知
    int addNotice(Notice notice);

    //删除一个通知
    int deleteNotice(Integer notice_id);
    //分页查询
    IPage<Notice> selectPage(IPage<Notice> page, @Param(Constants.WRAPPER) Wrapper<Notice> queryWrapper);
}
