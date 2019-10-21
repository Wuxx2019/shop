package com.shop.service.impl;

import com.shop.common.page.Page;
import com.shop.common.page.Query;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.entity.UserInfo;
import com.shop.service.UserService;
import com.shop.utils.ConstantUtil;
import com.shop.utils.MD5Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：UserServiceImpl
 * @Description：用户信息操作业务层实现
 * @Author：wuxingxing
 * @Date：2019/10/14 15:49
 */
public class UserServiceImpl  implements UserService {

    @Override
    public List<UserInfo> getUserList(Map<String, Object> params) {
        UserDao userDao=new UserDaoImpl();
        return userDao.getUserList(params);
    }

    @Override
    public boolean saveUser(UserInfo user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.saveUser(user);
    }

    @Override
    public boolean updateUserById(UserInfo user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.updateUserById(user);
    }

    @Override
    public boolean deleteUserById(UserInfo user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.deleteUserById(user);
    }

    @Override
    public boolean getUserById(UserInfo user) {
        UserDao userDao=new UserDaoImpl();
        return userDao.getUserById(user);
    }

    @Override
    public Page<UserInfo> queryPageList(Map<String, Object> params) {
        UserDao userDao = new UserDaoImpl();
        Query query = new Query(params);
        List<UserInfo> adminRoleList = getUserList(query);
        int total = userDao.getUserPageTotal(params);
        return new Page<UserInfo>(total,adminRoleList);
    }

    @Override
    public String login(String userName,String password) {
        if(null == userName || ConstantUtil.COMMON_STR_NULL.equals(userName)){
            return ConstantUtil.MSG_LOGIN_USER;
        }
        if(null == password || ConstantUtil.COMMON_STR_NULL.equals(password)){
            return ConstantUtil.MSG_LOGIN_PAS;
        }
        UserDao userDao = new UserDaoImpl();
        Map<String, Object> params = new HashMap<>();
        params.put(ConstantUtil.COMMON_STR_USER,userName);
       List<UserInfo> userInfoList = userDao.getUserList(params);
       //查询到结果说明用户名密码正确
        if(userInfoList.size() == 1){
           if(MD5Util.stringToMD5(password).equals(userInfoList.get(0).getPassword())) {
               return ConstantUtil.MSG_LOGIN_SUCCESS;
           }
            return ConstantUtil.MSG_LOGIN_PAS;
        }
        return ConstantUtil.MSG_LOGIN_USER;
    }

    /**测试*/
//    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        System.out.println(userService.login("111", "111"));
//
//    }
}