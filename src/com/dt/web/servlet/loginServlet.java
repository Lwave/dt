package com.dt.web.servlet;

import com.dt.entity.User;
import com.dt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        System.out .println("login的request:"+request);
        //2.获取数据
        //2.1  用户填写的验证码
        String verifycode = request.getParameter("verifycode");
        //3.验证码的校验
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute(checkCode_session);//验证码一次销毁
        if (!checkCode_session.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //4.封装User对象 getParameter()是获取POST/GET传递的參数值。
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建空的User
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        //5.调用Service查询
        UserServiceImpl service = new UserServiceImpl();
        User user = service.login(loginuser);
        //5.判断是否登录成功
        if (user != null) {
            //登陆成功
            //将用户存入session
            session.setAttribute("user", user);
            response.sendRedirect("/index.jsp");

        } else {
            //登录失败
            //提示信息
            request.setAttribute("login_msg", "用户名或密码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
