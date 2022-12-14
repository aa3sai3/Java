<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>应聘人信息</title>
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.js"></script>
</head>
<body>
<form id="userForm"
      method="post">
    <table class="table table-bordered table-hover">
        <tr>
            <td>登录名</td>
            <td>性别</td>
            <td>电话</td>
            <td>邮箱</td>
            <td>描述</td>
            <td>地址</td>
            <td>工作状态</td>
            <td>期望工资</td>
            <td>毕业学校</td>
        </tr>
        <tr>
            <td>${user.loginName}</td>

            <td>${user.gender }</td>

            <td>${user.telephone }</td>

            <td>${user.email }"</td>

            <td>${user.descripte }</td>

            <td>${user.address }</td>

            <td>${user.jobStatus}</td>

            <td>${user.salary}</td>

            <td>${user.school}</td>

<%--            <td><a href="${pageContext.request.contextPath }/user/editUser.do?id=${user.uid}">修改</a>--%>
<%--            </td>--%>
        </tr>
    </table>
</form>
</body>

</html>
