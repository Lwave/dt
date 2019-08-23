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
    <script type="text/javascript">

            //切换验证码
            function  refreshCode(){
                //1.获取验证码对象
                var vcode = document.getElementById("vcode");
                //2.设置其src属性，加时间戳
                vcode.src ="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>

</head>
<body>
<div class="container" style="margin-top: 100px;width: 500px;height: 500px; background-color: lightgoldenrodyellow">
    <h3 style="text-align:center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="username" style="margin-left: 20px">用户名:</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="请输入用户名" style="width: 400px;margin-left: 15px">
        </div>
        <div class="form-group" style="margin-left: 20px">
            <label for="password">密&nbsp;&nbsp;&nbsp;码:</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" style="width: 395px;margin-left:0px">
        </div>
        <div class="form-inline">
            <label for="vcode"  style="margin-left: 20px">验证码:</label>
            <input type="text" name="verifycode" id="verifycode" class="form-control" placeholder="请输入验证码" style="margin-left:5px">
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet"
                                                    title="看不清点击刷新" id="vcode"></a>
        </div>
        <hr>
        <div class="form-group" style="text-align: center">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <%--出错框的信息框--%>
    <div class="alert alert-warning alert-dismissable" role="alert" style="width: 400px;margin-left: 20px">
        <button type="button" class="close" data-dismiss="alert">
            <span>x</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>
</body>
</html>
