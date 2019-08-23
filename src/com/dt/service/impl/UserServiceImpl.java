package com.dt.service.impl;


import com.dt.dao.Impl.UserDaoImpl;
import com.dt.dao.UserDao;
import com.dt.entity.PageBean;
import com.dt.entity.User;
import com.dt.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao来完成查询
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if (uids != null && uids.length > 0) {
            //1.遍历数组
            for (String id : uids) {
                //2.调用dao删除
                userDao.delete(Integer.parseInt(id));
            }
        }
    }


    public User findUserById(int id) {
        return userDao.findById(id);
    }

    /*分页查询*/

    public PageBean<User> findUserBypage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用Dao查询总记录数
        int totalCount = userDao.findTotalCount(condition);
        System.out.println(totalCount);
        pb.setTotalCount(totalCount);

        //4.调用Dao查询list集合
        //记录开始的索引
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findByPage(start, rows, condition);
        pb.setList(list);
        //5.记录总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        if (pb.getCurrentPage() >= pb.getTotalPage()) {
            pb.setCurrentPage(pb.getTotalPage());
        }
        return pb;
    }
}
