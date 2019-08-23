<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改用户</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>

</head>

<body>
   <div class="container" style="margin: auto">
    <h3 style="text-align:center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
      <%--隐藏域--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" name="name" id="name" class="form-control" value="${user.name}" readonly="readonly" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label>性别:</label>
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked="checked">男
                <input type="radio" name="gender" value="女">女
            </c:if>
            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女" checked="checked">女
            </c:if>
        </div>
        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" name="age" id="age" class="form-control" value="${user.age}" placeholder="请输入年龄">
        </div>
        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <c:if test="${user.address == '山西'}">
                    <option value="山西" selected>山西</option>
                    <option value="陕西">陕西</option>
                    <option value="上海">上海</option>
                </c:if>
                <c:if test="${user.address == '陕西'}">
                    <option value="山西" >山西</option>
                    <option value="陕西" selected>陕西</option>
                    <option value="上海">上海</option>
                </c:if>
                <c:if test="${user.address == '上海'}">
                    <option value="山西" >山西</option>
                    <option value="陕西">陕西</option>
                    <option value="上海" selected>上海</option>
                </c:if>
                <c:if test="${user.address == '广东'}">
                    <option value="山西" >山西</option>
                    <option value="陕西">陕西</option>
                    <option value="上海">上海</option>
                    <option value="广东" selected>广东</option>
                </c:if>
            </select>
        </div>
        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" value="${user.qq}" id="qq" name="qq" placeholder="请填入QQ号 ">
        </div>
        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" value="${user.email}" id="email" name="email" placeholder="请填入邮箱地址 ">
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
