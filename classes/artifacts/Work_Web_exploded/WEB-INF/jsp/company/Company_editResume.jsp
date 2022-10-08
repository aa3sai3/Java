<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.js"></script>
    <style type="text/css">
        #tableAll {
            margin-top: 30px;
            margin-left: 40px;
            margin-right: 40px;
        }
        table td input {
            width: 400px;
            height: 35px;
            background-color: #ffdab9;
            padding-left: 15px;
            margin-left: 5px
        }
        #resume{
            float:right;
            font-size: large;
        }

        #divTable {
            height: 79%;
            margin-left: 150px;
            margin-right: 100px;
        }
        #name{
            font-size:medium;
            padding-top:20px;
            padding-left:60px;
        }
        body {
            background-color: #fffafa
        }
    </style>
    <script type="text/javascript">
        function saveResume(){
            var companyLoginName=document.getElementById("companyLoginName").value;
            var companyPwd=document.getElementById("companyPwd").value;
            if(companyLoginName.length==0){
                alert("请输入登录名");
                return false;
            }else
            {
                var pattern = /^[0-9a-zA-Z]+$/;
                if(!pattern.test(document.getElementById("companyLoginName").value))
                {
                    alert('\n用户名只可输入数字或者字母!');
                    return false;
                }
            }
            if(companyPwd.length==0){
                alert("请输入密码");
                return false;
            }
            //$("#submitForm").submit();
            document.getElementById("submitForm").submit();
        }
    </script>
</head>
<body>

<form action="${path}/com/editResumeSubmit" method="post" id="submitForm";>
    <input type="hidden" name="cid" value="${company.cid}" />
    <div id="divTable">
        <table class="table table-hover table-bordered">
            <tr>
                <td colspan="3" align="center" style="padding-right: 110px;background-color:#f0ffff;">
                    <h3>公司信息</h3>
                    <a href="javascript:void(0)" onclick="saveResume()" id="resume">保存信息</a>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;"><img src="${path}/images/man.png" width="50" height="50"></td>
                <td>企业名称</td>
                <td> <input type="text" id="companyName"  name="companyName" value="${company.companyName}" > </td>
            </tr>
            <tr>
                <td style="text-align:right;">
                    <img src="${path}/images/y1.png" width="50" height="50"></td>
                <td>企业类型</td>
                <td><input type="text" id="companyType" name="companyType" value="${company.companyType}"></td>
            </tr>
            <tr>
                <td style="text-align:right;">
                    <img src="${path}/images/y2.png" width="50" height="50"></td>
                <td>登陆账号</td>
                <td><input type="text" id="companyLoginName" name="companyLoginName" value="${company.companyLoginName}"></td>
            </tr>
            <tr>
                <td style="text-align:right;">
                    <img  src="${path}/images/y3.png" width="50" height="50"></td>
                <td>登陆密码</td>
                <td><input type="text"  id="companyPwd" name="companyPwd" value="${company.companyPwd}"></td>
            </tr>
            <tr>
                <td style="text-align:right;">
                    <img src="${path}/images/y4.png" width="50" height="50"></td>
                <td>公司地址</td>
                <td><input type="text" id="companyAddress" name="companyAddress" value="${company.companyAddress}"></td>
            </tr>

            <tr>
                <td style="text-align:right;"><img src="${path}/images/y5.png" width="50" height="50"></td>
                <td>公司网站</td>
                <td><input type="text" id="companyWebsite" name="companyWebsite" value="${company.companyWebsite}"></td>
            </tr>
            <tr>
                <td style="text-align:right;"><img src="${path}/images/y7.png" width="50" height="50"></td>
                <td>企业描述</td>
                <td><input type="text" id="companyDesc" name="companyDesc" value="${company.companyDesc}"></td>
            </tr>
            <tr>
                <td style="text-align:right;"><img src="${path}/images/y6.png" width="50" height="50"></td>
                <td>员工数目</td>
                <td><input type="text" id="empNum" name="empNum" value="${company.empNum}">人 </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
