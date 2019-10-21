package com.shop.common.page;

import java.util.List;

/**
 * @ProjectName：personalKit
 * @ClassName：QueryPage
 * @Description：layui分页查询封装
 * @Author：wuxingxing
 * @Date：2019/9/10 11:59
 */
public class Page<T> {
    /**
     * 返回code
     */
    private int code = 0;

    /**
     * 返回结果
     */
    private String msg;

    /**总纪录数*/
    private int count;
    /**数据*/
    private List<T> data;

    public Page() {
    }

    public Page(int count, List<T> data) {
        this.code = 0;
        this.msg = "success";
        this.count = count;
        this.data = data;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}