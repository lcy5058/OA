package com.oa.commons.vo;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2019/12/11 0011
 */
public class Page <T>{
    private int pagenum;  //当page前页码
    private int pageSize;//页面大小
    private int pagesStartIndex;//当前页起始索引
    private int totalRow;//总记录数
    private int totalPages;//总页码
    private List<T> dates;//页面需要数据
    public Page() {
        pagenum = 1;
        pageSize = 3;
    }

    public Page(int pagenum, int pageSize) {
        if(pagenum<=0){
            pagenum=1;
        }else{
            this.pagenum = pagenum;
        }
        if(pageSize<=0){
            pageSize=3;
        }
        else{
        this.pageSize = pageSize;
    }
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPagesStartIndex() {
        return (pagenum-1)*pageSize;
    }


    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPages() {
        if(totalRow%pageSize==0) {
            totalPages = totalRow / pageSize;
        }
        else {
            totalPages = totalRow / pageSize+1;
        }
        return totalPages;
    }

    public List<T> getDates() {
        return dates;
    }

    public void setDates(List<T> dates) {
        this.dates = dates;
    }
}
