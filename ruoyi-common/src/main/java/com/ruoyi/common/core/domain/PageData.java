package com.ruoyi.common.core.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 *
 * @author meepo
 */
@ApiModel("分页数据")
public class PageData<T> implements Serializable
{
    /**
     * 消息状态码
     */
    @ApiModelProperty(value = "消息状态码")
    private int code;

    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String msg;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    private long total;

    /**
     * 列表数据
     */
    @ApiModelProperty(value = "列表数据")
    private List<T> rows;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private int pageNum;

    /**
     * 单页总数
     */
    @ApiModelProperty("单页总数")
    private int pageSize;

    /**
     * 单页总数
     */
    @ApiModelProperty("页数")
    private int pages;


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
