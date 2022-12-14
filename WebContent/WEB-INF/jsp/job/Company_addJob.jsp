<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加职位</title>
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/WdatePicker/calendar.js"></script>
<style type="text/css">
table td input {
	width: 500px;
	height: 35px;
	background-color: pink;
	padding-left: 10px;
	margin-left: 20px
}

#Left {
	text-align: right;
	padding-top: 15px;
}

#saveBtn {
	background-color: #fffacd;
	width: 120px;
	margin-right: 140px;
}

#divTable {
	height: 100%;
	margin-left: 90px;
	padding-left: 140px;
	margin-right: 50px;
}

body {
	background-color: #fff8dc
}
</style>
<script type="text/javascript">
		function check(){
			// var cid=document.getElementById("cid").value;
			// var jobName=document.getElementById("jobName").value;
			// var jobAddress=document.getElementById("jobAddress").value;
			// var jobSalary=document.getElementById("jobSalary").value;
			// var releaseTime=document.getElementById("releaseTime").value;
			var jobName=$("#jobName").val();
			var jobAddress=$("#jobAddress").val();
			var jobSalary=$("#jobSalary").val();
			var releaseTime=$("#releaseTime").val();
			var cid=$("#cid").val();
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
				 url:"${pageContext.request.contextPath}/job/addPJob",
				 // data:$("#test").serialize(),
				 data:{
					 cid:cid,
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
							var url="${pageContext.request.contextPath}/com/toAddPost";
							window.location.href=url;
						}else if("新增的职位名称不可以重复"==data.str){
							alert("添加失败,新增的职位名称不可以重复");
							var url="${pageContext.request.contextPath}/com/toAddPost";
							window.location.href=url;
						}else if("插入职位失败"==data.str){
							alert("添加失败");
							var url="${pageContext.request.contextPath}/com/toAddPost";
							window.location.href=url;
						}else{
							alert("添加失败");
							var url="${pageContext.request.contextPath}/com/toAddPost";
							window.location.href=url;
						}
					}
			}); 
		}
</script>

</head>
<body>
	<input type="hidden" id="cid" value="${sessionScope.currCom.cid}" />
	<div id="divTable">
		<table class="table table-hover">
			<tr>
				<td colspan="2" align="center" style="padding-right: 120px"><h3>发布职位</h3></td>
			</tr>
			<tr>
				<td id="tdLeft">职位名称:</td>
				<td><input type="text" name="jobName" id="jobName" /></td>
			</tr>
			<tr>
				<td id="tdLeft">工作地址:</td>
				<td><input type="text" name="jobAddress" id="jobAddress"/></td>
			</tr>
			<tr>
				<td id="tdLeft">职位薪资</td>
				<td><input type="text" name="jobSalary" id="jobSalary" /></td>
			</tr>
			<tr>
				<td id="tdLeft">发布时间</td>
				<td><input type="text" name="releaseTime" id="releaseTime" /></td>
		
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="button" value="发布职位"
					id="saveBtn" class="btn btn-default" onclick="check()" /></td>
			</tr>
		</table>
		</div>
</body>

</html>