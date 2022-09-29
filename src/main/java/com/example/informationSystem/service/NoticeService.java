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
    Notice selectById(Integer noticeId);
    boolean updateById(Notice notice);

    //增加一个通知
    boolean addNotice(Notice notice);

    //删除一个通知
    boolean deleteNotice(Integer noticeId);
    //分页查询
   List<Notice> selectName(String informedPeople,int noticeState);
}
