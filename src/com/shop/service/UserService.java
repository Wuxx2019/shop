package com.shop.service;

import com.shop.common.page.Page;
import com.shop.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：UserService
 * @Description：用户信息操作业务层
 * @Author：wuxingxing
 * @Date：2019/10/14 15:14
 */
public interface UserService {

    /**
     * 获取用户列表
     * @param params
     * @return
     */
    List<UserInfo> getUserList(Map<String ,Object> params);

    /**
     * 保存用户
     * @param user 用户信息
     * @return boolean
     */
    boolean saveUser(UserInfo user);

    /**
     * 根据Id修改用户信息
     * @param user 用户信息
     * @return boolean
     */
    boolean updateUserById(UserInfo user);

    /**
     * 根据Id删除用户信息
     * @param user 用户信息
     * @return boolean
     */
    boolean deleteUserById(UserInfo user);

    /**
     * 根据Id查询某个用户
     * @return
     */
    boolean getUserById(UserInfo user);

    /**
     * 根据用户名称查询用户信息，用于登录
     * @param userName 用户名
     * @param password 密码
     * @return String
     */
    String login(String userName,String password);

    /**
     * 获取指定数据
     *
     * @param params 分页查询参数
     * @return 对象列表
     */
    Page<UserInfo> queryPageList(Map<String, Object> params);

}