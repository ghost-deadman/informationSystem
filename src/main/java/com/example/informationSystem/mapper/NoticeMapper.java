package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.Notice;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author pcdn
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}
