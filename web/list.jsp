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
    <script type="text/javascript">
        function deleteUser(id) {
            //用户安全提示
            if (confirm("你确定删除吗？")) {
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id;
            }

        }

        window.onload = function () {
            //给删除选中绑定单击事件
            document.getElementById("deleteSelected").onclick = function () {
                if (confirm("你确定要删除条目吗？")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    //3.遍历
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个选中
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        //表单提交
                        document.getElementById("formId").submit();
                    }
                }
            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的状态为 firstCb的状态
                    cbs[i].checked = this.checked;
                }
            }

        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin: 35px;color: darkorchid;font-size: 40px">用户信息列表</h3>
    <div style="float: left;margin: 5px;width: 800px;">
        <form class="form-inline" action="/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" name="name" class="form-control" value="${condition.name[0]}" id="name" >
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="address" name="address" class="form-control" id="address" value="${condition.address[0]}">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="text" name="email" class="form-control" id="email" value="${condition.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float:right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelected">删除选中</a>
    </div>
    <form id="formId" action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                        <%--<td>${s.count}</td>--%>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        &nbsp;&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=10&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 10px">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
