package com.ruoyi.common.core.domain;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.enums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.util.List;

/**
 * 响应信息主体
 *
 * @author fujen
 */
@ApiModel(description = "结果返回类")
public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final ResponseEnum SUCCESS = ResponseEnum.SUCCESS;

    /**
     * 失败
     */
    public static final ResponseEnum FAIL = ResponseEnum.ERROR;


    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "返回内容")
    private String msg;

    @ApiModelProperty(value = "数据对象")
    private T data;

    public static <T> R<T> ok()
    {
        return restResult(SUCCESS, null);
    }

    public static <T> R<T> ok(T data)
    {
        return restResult(SUCCESS, data);
    }

    public static <T> R<T> ok(T data, String msg)
    {
        return restResult(SUCCESS, msg, data);
    }



    public static <T> R<T> fail()
    {
        return restResult(FAIL,null);
    }

    public static <T> R<T> fail(String msg)
    {
        return restResult(FAIL, msg, null);
    }

    public static <T> R<T> fail(T data, String msg)
    {
        return restResult(FAIL, msg, data);
    }

    public static <T> R<T> fail(int code, String msg)
    {
        return restResult(code, msg, null);
    }



    public static <T> R<T> toResult(int rows) {
        return rows > 0 ? ok() : fail();
    }

    public static <T> R<T> toResult(boolean bool) {
        return bool ? ok() : fail();
    }



    public static <T> R<T> result(int code, String msg, T data) {
        return restResult(code, msg, data);
    }


    public static <T> PageData<T> toPage(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        PageData<T> dataInfo = new PageData<>();
        dataInfo.setCode(ResponseEnum.SUCCESS.getCode());
        dataInfo.setMsg("查询成功");
        dataInfo.setTotal(pageInfo.getTotal());
        dataInfo.setRows(list);
        dataInfo.setPageSize(pageInfo.getPageSize());
        dataInfo.setPageNum(pageInfo.getPageNum());
        dataInfo.setPages(pageInfo.getPages());
        return dataInfo;
    }

    public static <T> PageData<T> toPageFAIL() {
        PageData<T> dataInfo = new PageData<>();
        dataInfo.setCode(ResponseEnum.FAIL.getCode());
        dataInfo.setMsg("查询失败");
        return dataInfo;
    }

    private static <T> R<T> restResult(ResponseEnum responseEnum, T data) {
        return restResult(responseEnum.getCode(), responseEnum.getMessage(), data);
    }

    private static <T> R<T> restResult(ResponseEnum responseEnum, String msg, T data) {
        return restResult(responseEnum.getCode(), msg, data);
    }

    private static <T> R<T> restResult(ResponseEnum responseEnum, Integer code, T data) {
        return restResult(code, responseEnum.getMessage(), data);
    }

    private static <T> R<T> restResult(int code, String msg, T data)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
