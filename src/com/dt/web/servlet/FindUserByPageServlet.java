package com.dt.web.servlet;

import com.dt.entity.PageBean;
import com.dt.entity.User;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows"); //每页显示的条数
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
           rows = "10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //2.调用service
        UserServiceImpl userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserBypage(currentPage, rows, condition);
        System.out.println(pb);
        //3.将pageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
