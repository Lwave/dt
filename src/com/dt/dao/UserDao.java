package com.dt.dao;

import com.dt.entity.User;

import java.util.List;
import java.util.Map;

/*
 * 用户操作的dao
 *create database day16;
use day16;
create table user(
id int primary key auto_increment,
name varchar(20) not null,
gender varchar(5),
age int,
address varchar(32),
qq varchar(20),
email varchar(50)
);
 * */
public interface UserDao {

    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void addUser(User user);

    void delete(int id);

    User findById(int id);

    void updateUser(User user);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    // 分页查询每页记录

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
