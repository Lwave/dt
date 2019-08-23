package com.dt.web.servlet;

import com.dt.service.UserService;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        //2.调用service删除
        UserService userService = new UserServiceImpl();
        userService.deleteUser(id);
        //3.跳转到查询所有的servlet
        response.sendRedirect("/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
