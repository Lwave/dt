<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>

</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请填入姓名">
        </div>
        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" checked="checked" value="男">男
            <input type="radio" name="gender" value="女">女
        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请填入年龄 ">
        </div>
        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="山西">山西</option>
                <option value="陕西">陕西</option>
                <option value="上海">上海</option>
            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请填入QQ号 ">
        </div>
        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请填入邮箱地址 ">
        </div>
        <div class="form-group">
            <input type="submit" value="提交" class="btn btn-primary">
            <input type="reset"  value="重置" class="btn btn-default">
            <input type="button" value="返回" class="btn btn-default">
        </div>
    </form>
</div>

</body>
</html>
