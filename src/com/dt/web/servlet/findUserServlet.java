package com.dt.web.servlet;

import com.dt.entity.User;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        //2.调用Service
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findUserById(id);
        //3.将user存入request
        request.setAttribute("user", user);
        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
