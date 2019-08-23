package com.dt.service;

import com.dt.entity.PageBean;
import com.dt.entity.User;

import java.util.List;
import java.util.Map;

/*
 *用户管理的业务接口
 * */
public interface UserService {
    //查询所有用户信息
    public List<User> findAll();

    //查询登录
    public User login(User user);

    //保存对象
    void addUser(User user);

    //根据id删除user
    void deleteUser(int id);

    //修改用户信息
    void updateUser(User user);

    //批量删除用户
    void delSelectedUser(String[] uids);

    //分页条件查询
    public PageBean<User> findUserBypage(String currentPage, String rows, Map<String, String[]> condition);
}
