<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<!-- 
	<script type="text/javascript" src="layui/layui.js"></script> -->
	<script type="text/javascript" src="layui/lay/dest/layui.all.js"></script>
	<script type="text/javascript" src="js/success.js"></script>
	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	<%@ include file="formData.jsp" %>
<body class="layui-text">
	<c:set value="${claList }" var="clist"></c:set>
	<div style="width:800px;">
		<table class="layui-table" id="example-r">
			<thead>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>班级</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${stuList.results }" var="student">
				<tr>
					<td>${student.s_id }</td>
					<td>${student.s_name }</td>
					<td>${student.s_age }</td>
					<td>${student.cid.c_name }</td>
					<td><button onclick="deleteStudent(${student.s_id })" class="layui-btn layui-btn-sm"><i class="layui-icon" style="font-size: 30px;">&#xe640;</i></button></td>
					<td><a href="javascript:updateStudent(${student.s_id })"><i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe642;</i></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<tags:pagination pages="${stuList }"/>
	</div>
	<input type="button" value="注册" class="layui-btn layui-btn-normal" onclick="tanchuceng()" />
</body>
<script>
	
</script>
</html>