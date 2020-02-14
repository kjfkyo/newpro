package com.huameng.mybatis;

import java.util.List;

/**
 * Created by yulei on 16-7-12.
 */
public class Page<T> {

    public static final int DEFAULT_PAGE_SIZE = 5;

    protected int pageNo = 1; // ��ǰҳ Ĭ��Ϊ��1ҳ
    protected int pageSize = DEFAULT_PAGE_SIZE; // ÿҳ��¼��
    protected long totalRecord = -1L; // �ܼ�¼��, Ĭ��-1
    protected int totalPage = -1; // ��ҳ��  Ĭ��-1
    protected int start;
    protected int end;


    protected List<T> results; // ��ǰҳ��¼List��ʽ
    public int getStart() {
        return (pageNo - 1) * pageSize;
    }

    public long getEnd() {
        return this.getStart() + pageSize > totalRecord ? totalRecord : this.getStart() + pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
        computeTotalPage();
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        computeTotalPage();
    }

    protected void computeTotalPage() {
        if (getPageSize() > 0 && getTotalRecord() > -1) {
            this.totalPage = (int) (getTotalRecord() % getPageSize() == 0 ? getTotalRecord() / getPageSize() : getTotalRecord() / getPageSize() + 1);
        }
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", start=" + start +
                ", end=" + end +
                ", results=" + results +
                '}';
    }
}