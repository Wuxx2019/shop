package com.shop.dao;

import com.shop.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：UserDao
 * @Description：查询数据库用户信息接口
 * @Author：wuxingxing
 * @Date：2019/10/14 12:28
 */
public interface UserDao {

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
     * 根据Id查找用户信息
     * @param user 用户信息
     * @return boolean
     */
    boolean getUserById(UserInfo user);

    /**
     *
     * @param params 查询参数
     * @return boolean
     */
    int getUserPageTotal(Map<String ,Object> params);
}