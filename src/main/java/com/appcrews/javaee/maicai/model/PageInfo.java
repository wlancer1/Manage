package com.appcrews.javaee.maicai.model;

/**
 * Created by micheal on 2017/8/23.
 */
public class PageInfo {
    private int pageNo;
    private final static int pageSize=5;
    private int allpage;
    public static PageInfo getPageInfo(){
        return  new PageInfo();
    }

    public int getAllpage() {
        return allpage;
    }

    public void setAllpage(int allpage) {
        this.allpage = allpage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public static int getPageSize() {
        return pageSize;
    }
    public static int countTotalPage(final int pageSize, final int allRow) {
        int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        return totalPage;
    }
}
