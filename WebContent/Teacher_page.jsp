<%@page import="pers.qlc.Student_sys.entity.Student"%>
<%@page import="pers.qlc.Student_sys.entity.Teacher"%>
<%@page import="pers.qlc.Student_sys.entity.Course"%>
<%@page import="pers.qlc.Student_sys.entity.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>学生选课管理系统</title>
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta charset="utf-8" content="">
<style type="text/css">
* {
	margin: 0;
	paddding: 0;
	line-height: 15px
}

#head {
	height: 90px;
	width: 100%;
	background: #004B97;
	box-shadow: 0px 2px 3px #000;
	position: absolute;
	top: 0px
}

#h_w {
	font-size: 23px;
}

#bottom {
	height: 50px;
	width: 100%;
	background: #6C6C6C;
	position: absolute;
	bottom: 0px;
}

#menu {
	height: 80%;
	width: 200px;
	background: #CFCDCD;
	box-shadow: 0px 2px 3px #000;
	line-height: 30px;
	position: absolute;
	left: 2px;
	top: 94px
}

li {
	list-style: none;
}

.main_box {
	height: 80%;
	width: 1320px;
	background: #fff;
	position: absolute;
	right: 5px;
	top: 94px;
	box-shadow: 0px 2px 3px #000;
}

.point {
	width: 100px;
	height: 30px;
	text-align: center;
	vertical-align: center;
	border: 1px solid black;
	background-color: #FFFFFF;
	background: #CFCDCD;
	font-size: 15px
}

</style>
<script type="text/javascript">

	function show(str) {
		var x1 = document.getElementsByName("main_box");
		for (var i = 0; i < x1.length; i++) {
			x1[i].style.display = "none";
		}
		document.getElementById(str).style.display = "";
	};
	function toVaild(){
		var pass1=document.getElementById("new_password").value;
		var pass2=document.getElementById("renew_password").value;
		var pass3=document.getElementById("old_password").value;
		var pass4='${password}';
		if(pass1==pass2&&pass1!=''&&pass3==pass4)
		{
	    	alert("修改成功！！！")
			return true;
		}
	    else{
			alert("请重新确认密码！！！");
			return false;
		}
	}
</script>
	<%
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		String loginName = (String)session.getAttribute("loginName");
		if(loginName==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
	%>
</head>
<body>

	<!-- 顶部条栏 -->
	<div id="head">
		<font color="white" id="h_w"><br> <br>&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;生&nbsp;选&nbsp;课&nbsp;系&nbsp;统</font>
		<p align="right"><font color="white	">当前用户：${loginName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></p><br>
		<p align="right">
			<a href='/Student_sys2.0/LogoutServlet' style="text-decoration:none;color:white">退出登录&nbsp;&nbsp;</a>
		</p>
	</div>
	
	<HR style="FILTER: alpha(opacity = 0, finishopacity = 100, style = 1)"
		width="99%" color="#987cb9" SIZE="3">
	
	<!-- 左侧功能菜单 -->
	<div id="menu">
		<ul>
			<br><br><br>
			<li><input type="button" onclick=show("div3") value="我的信息"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div2") value="我的课表"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div1") value="修改密码"
				class="point" style="border: 0; cursor: pointer" /></li>
		</ul>
	</div>
	
	<!-- 底部条栏 -->
	<div id="bottom">
		<div style="text-align: center;">
			<br> <font color="white">Welcome to the student management system</font>
		</div>
	</div>
	<!-- 修改密码 -->
	<div class="main_box" name="main_box" style="display: none" id="div1">
		<form action="/Student_sys/ChangePassServlet" method="post" onSubmit="return toVaild()" >
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">修改密码</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
    	<tr>
        	<td width="40%" align="right">原密码：</td>
            <td><input name="old_password" type="password" maxlength="16" id="old_password"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">新密码：</td>
           <td><input name="new_password" type="password" maxlength="16" id="new_password"></td>
        </tr>
        <tr>
        <td width="40%" align="right">确认密码：</td>
            <td><input name="renew_password" type="password" maxlength="16" id="renew_password"></td>
        </tr>
        <tr>
        	<td align="right"><input type="submit" value="提交" style="font-size:10px"/></td>
            <td><input type="reset" value="重置" style="font-size:10px"/></td>
        </tr>
        </tbody>
        </table>
        </form>
	</div>
	<!-- 我的信息 -->
	<div class="main_box" name="main_box" style="display: none" id="div3">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">我的信息</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
    	<tr>
        	<td width="40%" align="right">教师号：</td>
            <td>${Queryme_teacher.username}</td>
        </tr>
        <tr>
        	<td width="40%" align="right">姓名：</td>
            <td>${Queryme_teacher.tname}</td>
        </tr>
        <tr>
        	<td width="40%" align="right">性别：</td>
            <td>${Queryme_teacher.tsex}</td>
        </tr>
        <tr>
        	<td width="40%" align="right">出生年：</td>
            <td>${Queryme_teacher.tage}</td>
        </tr>
        <tr>
        	<td width="40%" align="right">职称：</td>
            <td>${Queryme_teacher.tjob}</td>
        </tr>
        </tbody>
        </table>
        <HR style="FILTER: alpha(opacity = 0, finishopacity = 100, style = 1)"
		width="100%" color="grey" SIZE="3">
	</div>
	<!-- 课程管理 -->
	<div class="main_box" name="main_box" style="display: none" id="div2">
		<table border="0px"  width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="4" bgcolor="#DCDCDC" align="left">我的课表</th>
            </tr>
            <tr>
                <th bgcolor="#DCDCDC">课序号</th>
                <th bgcolor="#DCDCDC">课程名称</th>
                <th bgcolor="#DCDCDC">星期</th>
                <th bgcolor="#DCDCDC">节次</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
       		 <c:forEach items="${Queryme_course}" var="course">
    			<tr>
        	  	<td width="25%" align="center">${course.cno }</td>
        	  	<td width="25%" align="center">${course.cname }</td>
        	  	<td width="25%" align="center">${course.cday }</td>
        	  	<td width="25%" align="center">${course.ctime }</td>
        	  </tr>  
    		 </c:forEach>  
        	  
        </tbody>
        </table>	
        </div>	
</body>
</html>
