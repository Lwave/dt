package com.dt.web.servlet;

import com.dt.service.UserService;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedServlet")
public class deleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有用户的uid
        String[] uids = request.getParameterValues("uid");
        //2.调用service
        UserService service = new UserServiceImpl();
        service.delSelectedUser(uids);
        //3.跳转页面
        response.sendRedirect("/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
