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
	function toCheck1(){
		var pass1=document.getElementById("insertpass1").value;
		var pass2=document.getElementById("reinsertpass1").value;
		var pass3=document.getElementById("user1").value;
		if(pass1==pass2&&pass1!=''&&pass3!='')
		{
	    	alert("添加成功！！！")
			return true;
		}
	    else{
			alert("请重新确认密码！！！");
			return false;
		}
	}
</script>
</head>
<body>
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
	<!-- 顶部条栏 -->
	<div id="head">
		<font color="white" id="h_w"><br> <br>&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;生&nbsp;选&nbsp;课&nbsp;系&nbsp;统</font>
		<p align="right"><font color="white	">当前用户：${loginName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></p><br>
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
			<li><input type="button" onclick=show("div1") value="密码修改"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div2") value="系统管理"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div3") value="课程管理"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div4") value="教师管理"
				class="point" style="border: 0; cursor: pointer" /></li>
			<br>
			<li><input type="button" onclick=show("div6") value="学生管理"
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
		<form action="/Student_sys2.0/ChangePassServlet" method="post" onSubmit="return toVaild()" >
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
	
	<!-- 账号管理 -->
	<div class="main_box" name="main_box" style="display: none" id="div2">
    	<form action="#" method="post">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="3" bgcolor="#DCDCDC" align="left">管理员</th>
            </tr>
            <tr>
                <th bgcolor="#DCDCDC">账号</th>
                <th bgcolor="#DCDCDC">密码</th>
                <th bgcolor="#DCDCDC">操作</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5"> 
        <c:forEach items="${QueryAdmin}" var="admin">
        	  <tr>
        	  	<td width="30%" align="center">${admin.username }</td>
        	  	<td width="30%" align="center">${admin.password }</td>
        	  	<td width="40%" align="center">
        	  		<a href='/Student_sys2.0/DeleteServlet?username=${admin.username}&type=admin'
        	  		 style="text-decoration:none;color:black">删除</a>
        	  	</td>
        	  </tr>  
        </c:forEach>
        	
        </tbody>
        </table>
        <input type="button" onclick=show("div7") value="添加管理员"
				class="point" style="border: 0; cursor: pointer" />		
        </form>
    </div>
	
	<!-- 课程管理 -->
	<div class="main_box" name="main_box" style="display: none" id="div3">
		<form action="#" method="post">
		<table border="0px"  width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="7" bgcolor="#DCDCDC" align="left">已有课程</th>
            </tr>
            <tr>
                <th bgcolor="#DCDCDC">课序号</th>
                <th bgcolor="#DCDCDC">课程名称</th>
                <th bgcolor="#DCDCDC">教师</th>
                <th bgcolor="#DCDCDC">星期</th>
                <th bgcolor="#DCDCDC">节次</th>
                <th bgcolor="#DCDCDC">操作</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
        	 <c:forEach items="${QueryCourse}" var="course">   
        	  <tr>
        	  	<td width="15%" align="center">${course.cno }</td>
        	  	<td width="15%" align="center">${course.cname }</td>
        	  	<td width="15%" align="center">${course.tno}</td>
        	  	<td width="15%" align="center">${course.cday }</td>
        	  	<td width="15%" align="center">${course.ctime }</td>
        	  	<td width="25%" align="center">
        	  		<a href='/Student_sys2.0/DeleteServlet?username=${course.cno}&type=course'
        	  		 style="text-decoration:none;color:black">删除</a>
        	  	</td>
        	  </tr>  
        	</c:forEach>
	
        </tbody>
        </table>
        <input type="button" onclick=show("div8") value="添加课程"
				class="point" style="border: 0; cursor: pointer" />	
        </form>
	
	</div>
	
	<!-- 教师管理 -->
	<div class="main_box" name="main_box" style="display: none" id="div4">
		<form action="#" method="post">
			<table border="0px" width="100%" height="50px">
	        <thead>
	            <tr>
	                <th colspan="7" bgcolor="#DCDCDC" align="left">现有教师</th>
	            </tr>
	            <tr>
	                <th bgcolor="#DCDCDC">教师号</th>
	                <th bgcolor="#DCDCDC">密码</th>
	                <th bgcolor="#DCDCDC">姓名</th>
	                <th bgcolor="#DCDCDC">性别</th>
	                <th bgcolor="#DCDCDC">出生年</th>
	                <th bgcolor="#DCDCDC">职称</th>
	                <th bgcolor="#DCDCDC">操作</th>
	            </tr>
	        </thead>
	        <tbody bgcolor="#F5F5F5">
	        <c:forEach items="${QueryTeacher }" var="teacher">
	        	<tr>
	        	  	<td width="15%" align="center">${teacher.username }</td>
	        	  	<td width="15%" align="center">${teacher.password }</td>
	        	  	<td width="15%" align="center">${teacher.tname }</td>
	        	  	<td width="15%" align="center">${teacher.tsex }</td>
	        	  	<td width="15%" align="center">${teacher.tage }</td>
	        	  	<td width="15%" align="center">${teacher.tjob }</td>
	        	  	<td width="10%" align="center">
	        	  		<a href='/Student_sys2.0/DeleteServlet?username=${teacher.username}&type=teacher'
        	  		 style="text-decoration:none;color:black">删除</a>
	        	  	</td>
        	   	</tr> 
	        </c:forEach>   
        	  
	        </tbody>
	        </table>
	        <input type="button" onclick=show("div9") value="添加教师"
					class="point" style="border: 0; cursor: pointer" />			
		</form>
	</div>
	
	<!-- 学生管理 -->
	<div class="main_box" name="main_box" style="display: none" id="div6">
		<form action="#" method="post">
			<table border="0px" width="100%" height="50px">
	        <thead>
	            <tr>
	                <th colspan="9" bgcolor="#DCDCDC" align="left">现有学生</th>
	            </tr>
	            <tr>
	                <th bgcolor="#DCDCDC">学号</th>
	                <th bgcolor="#DCDCDC">密码</th>
	                <th bgcolor="#DCDCDC">姓名</th>
	                <th bgcolor="#DCDCDC">性别</th>
	                <th bgcolor="#DCDCDC">年龄</th>
	                <th bgcolor="#DCDCDC">专业</th>
	                <th bgcolor="#DCDCDC">班级</th>
	                <th bgcolor="#DCDCDC">年级</th>
	                <th bgcolor="#DCDCDC">操作</th>
	            </tr>
	        </thead>
	        <tbody bgcolor="#F5F5F5">
	        <c:forEach items="${QueryStudent }" var="student">
	        	<tr>
	        	  	<td width="12%" align="center">${student.username }</td>
	        	  	<td width="12%" align="center">${student.password }</td>
	        	  	<td width="12%" align="center">${student.sname }</td>
	        	  	<td width="12%" align="center">${student.ssex }</td>
	        	  	<td width="12%" align="center">${student.sage }</td>
	        	  	<td width="12%" align="center">${student.sdept }</td>
	        	  	<td width="12%" align="center">${student.sclass }</td>
	        	  	<td width="12%" align="center">${student.grade }</td>
	        	  	<td width="12%" align="center">
						<a href='/Student_sys2.0/DeleteServlet?username=${student.username}&type=student'
        	  		 style="text-decoration:none;color:black">删除</a>
					</td>
        	  	</tr> 
	        </c:forEach>   
        	   
	        </tbody>
	        </table>
	        <input type="button" onclick=show("div11") value="添加学生"
					class="point" style="border: 0; cursor: pointer" />	
        </form>
	</div>
	
	<!-- 添加管理员账号 -->
	<div class="main_box" name="main_box" style="display: none" id="div7">
		<form action="/Student_sys2.0/InsertAminServlet" method="post" onSubmit="return toCheck1()">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">添加管理员账号</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
        <tr>
        	<td width="40%" align="right">用户名：</td>
            <td><input name="admin_username" type="text" maxlength="16" id="user1"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">密码：</td>
            <td><input name="admin_password" type="password" maxlength="16" id="insertpass1"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">确认密码：</td>
            <td><input type="password" maxlength="16" id="reinsertpass1"></td>
        </tr>
        <tr>
        	<td width="40%" align="right"><input type="submit" value="提交" style="font-size:10px"/></td>
            <td><input type="reset" value="重置" style="font-size:10px"/></td>
        </tr>
        </tbody>
        </table>
        </form>
	</div>
	
	<!-- 添加课程 -->
	<div class="main_box" name="main_box" style="display: none" id="div8">
		<form action="/Student_sys2.0/InsertCourseServlet" method="post">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">添加课程</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
        <tr>
        	<td width="40%" align="right">课序号：</td>
            <td><input name="Cno" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">课程名称：</td>
            <td><input name="Cname" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">教师号：</td>
            <td><input name="Cteacher" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">星期：</td>
            <td><select name="Cday">	
                    <option value="一">一</option>
                    <option value="二">二</option>
                    <option value="三">三</option>
                    <option value="四">四</option>
                    <option value="五">五</option>
                    <option value="六">六</option>
                    <option value="日">日</option>
                	</select></td>
        </tr>
        <tr>
        	<td width="40%" align="right">节次：</td>
            <td><select name="Ctime">	
                    <option value="1-2">1-2</option>
                    <option value="3-4">3-4</option>
                    <option value="5-6">5-6</option>
                    <option value="7-8">7-8</option>
                    <option value="9-10">9-10</option>
                	</select></td>
        </tr>
        <tr>
        	<td width="40%" align="right"><input type="submit" value="提交" style="font-size:10px"/></td>
            <td><input type="reset" value="重置" style="font-size:10px"/></td>
        </tr>
        </tbody>
        </table>
        </form>
	</div>
	
	<!-- 添加教师 -->
	<div class="main_box" name="main_box" style="display: none" id="div9">
		<form action="/Student_sys2.0/InsertTeacherServlet" method="post">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">添加教师</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
        <tr>
        	<td width="40%" align="right">教师号：</td>
            <td><input name="Tno" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">密码：</td>
            <td><input name="password" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">姓名：</td>
            <td><input name="Tname" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">性别：</td>
            <td><select name="Tsex">	
                    <option value="男">男</option>
                    <option value="女">女</option>
                	</select></td>
        </tr>
        <tr>
        	<td width="40%" align="right">出生年：</td>
            <td><input name="Tage" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">职称：</td>
            <td><select name="Tjob">	
                    <option value="教授">教授</option>
                    <option value="副教授">副教授</option>
                    <option value="讲师">讲师</option>
                	</select></td>
        </tr>
        <tr>
        	<td width="40%" align="right"><input type="submit" value="提交" style="font-size:10px"/></td>
            <td><input type="reset" value="重置" style="font-size:10px"/></td>
        </tr>
        </tbody>
        </table>
        </form>
	</div>
	
	<!-- 添加学生 -->
	<div class="main_box" name="main_box" style="display: none" id="div11">
		<form action="/Student_sys2.0/InsertStudentServlet" method="post">
		<table border="0px" width="100%" height="50px">
        <thead>
            <tr>
                <th colspan="2" bgcolor="#DCDCDC" align="left">添加课程</th>
            </tr>
        </thead>
        <tbody bgcolor="#F5F5F5">
        <tr>
        	<td width="40%" align="right">学号：</td>
            <td><input name="Sno" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">姓名：</td>
            <td><input name="Sname" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">密码：</td>
            <td><input name="password" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">性别：</td>
            <td><select name="Ssex">	
                    <option value="男">男</option>
                    <option value="女">女</option>
                	</select></td>
        </tr>
        <tr>
        	<td width="40%" align="right">出生年：</td>
            <td><input name="Sage" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">专业：</td>
            <td><input name="Sdept" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">班级：</td>
            <td><input name="Sclass" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right">年级：</td>
            <td><input name="Sgrade" type="text" maxlength="16"></td>
        </tr>
        <tr>
        	<td width="40%" align="right"><input type="submit" value="提交" style="font-size:10px"/></td>
            <td><input type="reset" value="重置" style="font-size:10px"/></td>
        </tr>
        </tbody>
        </table>
        </form>
        </div>
</body>
</html>
