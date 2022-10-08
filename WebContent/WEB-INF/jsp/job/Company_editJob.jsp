<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户信息</title>
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.js"></script>

    <script type="text/javascript">
        function submitForm() {
            var jobId=document.getElementById("jobId").value;
            var cid=document.getElementById("cid").value;
            var TempJobName=document.getElementById("TempJobName").value;
            var jobName=document.getElementById("jobName").value;
            var jobAddress=document.getElementById("jobAddress").value;
            var jobSalary=document.getElementById("jobSalary").value;
            var releaseTime=document.getElementById("releaseTime").value;
            if(jobName.length==0){
                alert("工作名称不能为空");
                return false;
            }
            if(jobAddress.length==0){
                alert("工作地址不能为空");
                return false;
            }
            if(jobSalary.length==0){
                alert("工作薪资不能为空！");
                return false;
            }
            if(releaseTime.length==0){
                alert("发布时间不能为空！");
                return false;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/job/editJobSubmit",
                data:{
                    jobId:jobId,
                    cid:cid,
                    TempJobName:TempJobName,
                    jobName:jobName,
                    jobAddress:jobAddress,
                    jobSalary:jobSalary,
                    releaseTime:releaseTime
                },
                type:"POST",
                dataType:"JSON",
                error:function(XMLHttpRequest, textStatus, errorThrown){//如果确定能正确运行,可不写
                    alert(XMLHttpRequest.status);//400

                    alert(XMLHttpRequest.readyState);//4

                    alert(textStatus);//error
                },
                success:function(data){
                    if("fail"==data.str){
                        alert("您还没有登录，请先登录！");
                        var url="${pageContext.request.contextPath}/com/login";
                        window.parent.location.href=url;
                    }else if("success"==data.str){
                        alert("添加职位成功");
                        var url="${pageContext.request.contextPath}/com/toSelectPost";
                        window.location.href=url;
                    }else if("新增的职位名称不可以重复"==data.str){
                        alert("添加失败,新增的职位名称不可以重复");
                        var url="${pageContext.request.contextPath}/com/toSelectPost";
                        window.location.href=url;
                    }else if("插入职位失败"==data.str){
                        alert("添加失败");
                        var url="${pageContext.request.contextPath}/com/toSelectPost";
                        window.location.href=url;
                    }else{
                        alert("添加失败");
                        var url="${pageContext.request.contextPath}/com/toSelectPost";
                        window.location.href=url;
                    }
                }
            });
            //document.getElementById("jobForm").submit();
        }
    </script>
    <style type="text/css">
        #Left {
            text-align: right;
            padding-left: 140px;
            padding-top: 15px;
        }

        #divTable {
            margin: 40px;
            padding-left: 50px;
        }

        table td input {
            width: 500px;
            height: 35px;
            padding-left: 30px;
            margin-left: 20px
        }

        body {
            background-color: #fff8dc
        }
    </style>

</head>
<body>
<%--<form id="jobForm" action="${pageContext.request.contextPath }/job/editJobSubmit" method="post" onsubmit="return submitForm();">--%>
    <form id="jobForm">
        <input type="hidden" name="jobId" value="${job.jobId }"  id="jobId" />
        <input type="hidden" name="cid" value="${job.cid }"  id="cid" />
        <input type="hidden" name="TempJobName" value="${TempJobName}"  id="TempJobName" />

    <div id="divTable">
        <table class="table table-striped table-hover">
            <tr class="info">
                <td colspan="2" align="center" style="padding-right: 150px;"><h3>修改职位信息</h3></td>
            </tr>
            <tbody>
            <tr>
                <td id="tdLeft">职位名称:</td>
                <td><input type="text" name="jobName" id="jobName"
                           value="${job.jobName}" /></td>
            </tr>
            <tr>
                <td id="tdLeft">工作地点:</td>
                <td><input type="text" name="jobAddress" id="jobAddress"
                           value="${job.jobAddress }" /></td>
            </tr>
            <tr>
                <td id="tdLeft">薪资:</td>
                <td><input type="text" name="jobSalary" id="jobSalary"
                           value="${job.jobSalary}" /></td>
            </tr>
            <tr>
                <td id="tdLeft">发布时间:</td>
                <td><input type="text" name="releaseTime" id="releaseTime"
                                 value ="<fmt:formatDate value="${job.releaseTime}" pattern="yyyy-MM-dd" />"></td>
            </tr>

            <tr>
                <td colspan="3" align="center">
                    <button type="button" class="btn btn-primary btn-lg"
                            onclick="submitForm();">保存</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>

</html>
