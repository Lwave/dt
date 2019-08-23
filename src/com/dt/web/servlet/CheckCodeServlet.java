package com.dt.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //这个方法实现验证码的生成
        BufferedImage bi = new BufferedImage(68, 30, BufferedImage.TYPE_INT_RGB);//创建图像缓冲区

        Graphics g = bi.getGraphics(); //通过缓冲区创建一个画布

        Color c = new Color(255, 255, 255); //创建颜色
        /*根据背景画了一个矩形框
         */
        g.setColor(c);//为画布创建背景颜色

        g.fillRect(0, 0, 68, 30); //fillRect:填充指定的矩形
        // X和Y用于指定矩形左上角也就是相对于原点的位置，width和height用于指定矩形的宽和高。

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();//转化为字符型的数组
        Random r = new Random();
        int len = ch.length;
        int index; //index用于存放随机数字
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            index = r.nextInt(len);//产生随机数字
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));  //设置颜色随机
            g.drawString(ch[index] + "", (i * 15) + 3, 18);//画数字以及数字的位置
            sb.append(ch[index]);
        }
        String checkCode_session = sb.toString();
        //将验证码存入session中
        request.getSession().setAttribute("checkCode_session", checkCode_session);
        //request.getSession().setAttribute("piccode", sb.toString()); //将数字保留在session中，便于后续的使用
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
