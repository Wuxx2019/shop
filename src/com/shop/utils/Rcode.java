package com.shop.utils;
/**
 * @ProjectName：shop
 * @ClassName：Rcode
 * @Description：返回结果类
 * @Author：wuxingxing
 * @Date：2019/10/17 14:23
 */
public class Rcode{
    private int code;
    private String msg;
    private Object data;

    public Rcode(String msg) {
        this.msg = msg;
    }

    public Rcode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Rcode(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}