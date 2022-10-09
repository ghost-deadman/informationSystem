package com.example.informationSystem.utils;

import lombok.Data;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 16:52
 * 分页工具类
 * @param <T>
 */
@Data
public class Pager<T> {

    /**
     *总记录数
     */
    private long total;
    /**
     *起始位置
     */
    private long offset;
    /**
     *总页数
     */
    private long pageCount;
    /**
     *数据
     */
    private List<T> dataList;
    /**
     *当前页
     */
    private long currentPage;
    /**
     *下一页
     */
    private long nextPage;
    /**
     *上一页
     */
    private long provPage;
    /**
     *每页数据条数
     */
    private long size;

    public Pager(long currentPage,long total,long size){

        if(currentPage < 1){
            //默认第一页
            this.currentPage=1;
        }else{
            //得到当前页
            this.currentPage= currentPage;
        }

        this.total= total;

        this.size = size;
        //计算起始位置
        this.offset= (this.currentPage-1)* this.size;
        //计算总页数
        this.pageCount = total % size >0 ? total/size +1 : total / size;
        //计算下一页 : 判断当前页是否是最后一页：是，下页就是总页数 ,否则当前页+1
        this.nextPage = this.currentPage == this.pageCount ? this.pageCount: ++this.currentPage;
        //计算上页：
        this.provPage = this.currentPage == 1 ? 1 : this.currentPage-1;
    }

    public Pager(long currentPage, long size) {

        this.offset = (this.currentPage-1)* this.size;

        this.currentPage = currentPage;

        this.size = size;

    }

    public Pager() {
    }


}