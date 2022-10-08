<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>body</title>
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.js"></script>
    <style type="text/css">
        #divMain {
            width: 1000px;
            height: 100%;
        }
        th,td{text-align: center;}
        #search{
            height:36px;
            width:210px;
            text-align:center;
        }
        #input{height:100px;background-color:#ccc;}
    </style>
    <script type="text/javascript">
        function search(){
            $("#searchForm").submit();
        }
    </script>

</head>

<body>
<div id="divMain">
    <div id="divTable">
        <form action="${path}/job/showCompanyJob" id="searchForm" method="post">
                <input type="hidden" name="jobName" />
                <input type="hidden" name="jobAddress" />
                <input type="hidden" name="companyName" value=${sessionScope.currCom.companyName} />
                <button type="button" class="btn btn-default" onclick="search()" style="background-color:#afeeee;height:36px;width:100px;">显示在招职位</button>
        </form>
        <table class="table table-hover table-hover">
            <tr class="info">
                <td colspan="10"><h3>职位列表</h3></td>
            </tr>
            <tr class="danger">
                <th>职位名称</th>
                <th>工作地点</th>
                <th>公司名</th>
                <th>薪资</th>
                <th>发布时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${CompanyJobInfoList}" var="jobInfo">
                <tr class="table table-hover">
                    <td>${jobInfo.jobName}</td>
                    <td>${jobInfo.jobAddress}</td>
                    <td>${jobInfo.company.companyName}</td>
                    <td>${jobInfo.jobSalary}</td>
                    <td><fmt:formatDate value="${jobInfo.releaseTime}" pattern="yyyy-MM-dd" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath }/job/editJob?cid=${jobInfo.cid}&jobName=${jobInfo.jobName}"
                           class="btn btn-default" onclick="return confirm('确定要修改吗？');">修改</a>
                        <a href="${pageContext.request.contextPath }/job/deleteJob?jobName=${jobInfo.jobName}"
                           class="btn btn-default" onclick="return confirm('确定删除吗？');">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
