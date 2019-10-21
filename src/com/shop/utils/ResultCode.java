package com.shop.utils;

/**
 * @ProjectName：personalKit
 * @ClassName：ResultCode
 * @Description：自定义状态码
 * @Author：wuxingxing
 * @Date：2019/8/23 15:14
 */
public enum ResultCode {
    // 自定义状态码
    /**
      * 正确的请求返回正确的结果
      */
    SUCCESS(0,"请求成功"),
    /**
       * 错误的凭证 密码错误（登陆相关） LOGIN 10 开始
       */
    FAIL_LOGIN_PAS(10, "密码错误"),
    /**
      * 登录失败次数过多
      */
    FAIL_LOGIN_NUM(11,"登录失败次数过多"),
    /**
      * 用户名错误
      */
    FAIL_LOGIN_ACCOUNT(12,"账号不存在"),
    /**
     * 过期的凭证
      */
    FAIL_LOGIN_TIME(13,"过期的凭证"),
    /**
     * 锁定的帐号 ACCOUNT（账号信息相关） 50开始
      */
    FAIL_ACCOUNT_LOCK(50,"账号已锁定"),

    /**
     * 禁用的帐号
      */
    FAIL_ACCOUNT_DIS(51,"账号已被禁用"),
    /**
     * 锁定的帐号 ACCOUNT（账号信息相关） 50开始
      */
    FAIL_ACCOUNT_ONLY(52,"账号已在他处登录，现已经将其踢出，请重新登录！"),


    FAIL_ACCOUNT_EXPIRED(53,"您的账号已在其他地方登陆，如自己不知，请及时联系管理员！！"),

    /**
     * 查询的结果为空 DATA（数据处理业务相关） 100 开始
      */
    FAIL_DATA_NULL_ERROR(100,"查询的结果为空"),
    /**
     * 删除出错
      */
    FAIL_DATA_DELETE_ERROR(101,"删除错误"),
    FAIL_DATA_DELETE(102,"删除成功，返回删除数量"),
    /**
     * 增加出错
      */
    FAIL_DATA_SAVE_ERROR(103,"增加错误"),
    FAIL_DATA_SAVE(104,"增加成功，返回增加数量"),
    /**
     * 修改出错
      */
    FAIL_DATA_UPDATE_ERROR(105,"修改错误"),
    FAIL_DATA_UPDATE(106,"修改成功，返回修改数量");


    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

}