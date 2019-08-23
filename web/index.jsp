<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>首页</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="js/jquery-3.3.1.min.js"></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript"></script>
  <style>
    a:hover{
      text-decoration: none;
    }
  </style>
</head>
<body>
<div style="margin: 30px"><span style="color: #ff65ea;font-size: 40px;">${user.name},欢迎您！</span></div>
<div align="center" style="margin-top: 50px">
  <a href="${pageContext.request.contextPath}/findUserByPageServlet" style="font-size:40px;">查询所有用户信息</a>
</div>
</body>
</html>
