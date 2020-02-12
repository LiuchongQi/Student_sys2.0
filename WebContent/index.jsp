<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="Keywords" content="学生选课">
		<meta name="Description" content="这是一个学生选课管理系统">
		<title>学生选课管理系统</title>
		<style>
		*{margin:0;paddding:0;}
		.textbox{ height:250px; width:300px;position:absolute;background:#FFFFFF;background:rgba(255,255,255,0.5);
				margin:auto;top: 0;left: 0;right: 0;bottom: 0;padding:30px;} 
		.botton{width:300px;height:40px;border-radius:2px;background:#005AB5;}
		.input{width:300px;height:30px;text-align:center;vertical-align:center;
			border:1px solid black;background-color:#FFFFFF;background:rgba(255,255,255,1)} 
		</style>
	
		
		 <script> 
			  var errori ='<%=request.getParameter("error")%>';
			  if(errori=='yes'){
			   alert("登录失败!");
			  }
		</script>
	
 	</head>
	<body>
		<div style="position:absolute; left:0px; top:0px; width:100%; height:100%">  
			<img src="image/timg.jpg" width="100%" height="100%"/>  
			<div class="textbox">
				<form action="/Student_sys2.0/LoginServlet" method="post"></br> 					
					<input name="username" type="text" class="input" maxlength="16" placeholder="Username/Email"/></br></br>	
					<input name="password" type="password" class="input" maxlength="16" placeholder="Password"/></br></br>
					<input type="checkbox"/>&nbsp;Remmeber Me
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select name="per_type">	
                    <option value="admin">admin</option>
                    <option value="teacher">teacher</option>
                    <option value="student">student</option>
                	</select><br/>
					<input type="submit" value="Login" class="botton" style="font-size:15px"/>
				</form>
			</div>
		</div>  
	</body>
</html>