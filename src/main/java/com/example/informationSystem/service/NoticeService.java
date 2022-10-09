package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.utils.Pager;

import java.util.List;

/**
 * @author pcdn
 */
public interface NoticeService {

    /**
     * 查询所有的通知数据
     * @return 通知数组
     */
    List<Notice> getAll();

    /**
     * 按通知人id查询通知
     * @param noticeId 通知id
     * @return 通知对象
     */
    Notice selectById(Integer noticeId);

    /**
     * 修改通知
     * @param notice 通知对象
     * @return 是否成功
     */
    boolean updateById(Notice notice);

    /**
     * 添加通知
     * @param notice 通知对象
     * @return 是否成功
     */
    boolean addNotice(Notice notice);

    /**
     * 删除通知
     * @param noticeId 删除某通知
     * @return 是否成功
     */
    boolean deleteNotice(Integer noticeId);

    /**
     * 按接收人和状态分页查询通知
     * @param informedPeople 接收人id
     * @param currentPage 页数
     * @param pageSize  每页数据条数
     * @param status 邮件状态
     * @return 通知数组
     */
    IPage<Notice> selectAllByUserIdPage(int status, String informedPeople, long currentPage, long pageSize);

    /**
     * 按状态获取收件人获取邮件数量
     * @param userId 用户id
     * @param status 状态
     * @return 数量
     */
    int getNoticeByStatusAndUserCount(String userId, int status);

    /**
     * 批量删除邮件
     * @param noticeIdList 邮件主键数组
     * @return 是否成功
     */
    boolean deleteNoticeBatch(List<String> noticeIdList);

    /**
     * 通知修改为已查看
     * @param noticeId 项目id
     * @return 是否成功
     */
    boolean updateNoticeStatusById(String noticeId);
}
