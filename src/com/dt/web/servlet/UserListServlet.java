package com.dt.web.servlet;

import com.dt.entity.User;
import com.dt.service.UserService;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.调用UserService来完成查询
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();
        //2.将list存入request域中
        request.setAttribute("users", users);
        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
