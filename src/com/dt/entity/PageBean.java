package com.dt.entity;

import java.util.List;

/**
 * 分页对象
 */
public class PageBean<U> {
    private int totalCount;  //总记录数
    private int totalPage;  //总页码 = 总记录数%每页显示条数 == 0 ？总记录数 /每页显示条数 ：总记录数 / 每页显示条数 + 1
    private List list;    //每页显示的list集合
    int currentPage;    //当前页码
    int rows;        //每页显示的条数

    public PageBean(int totalCount, int totalPage, List list, int currentPage, int rows) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
        this.rows = rows;
    }

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
