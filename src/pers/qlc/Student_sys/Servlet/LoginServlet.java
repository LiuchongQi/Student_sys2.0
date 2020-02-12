package pers.qlc.Student_sys.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qlc.Student_sys.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 设置编码为utf-8  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
		//1.接收参数
		
        String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		String per_type=request.getParameter("per_type");	
		//2.判断逻辑
		LoginService loginService=new LoginService(); 
		boolean isLogin=loginService.Login(userName, userPwd, per_type);
		if(isLogin){
			HttpSession session=request.getSession();
			session.setAttribute("loginName",userName);
			session.setAttribute("password",userPwd);
			session.setAttribute("type","admin");
			if(per_type.equals("admin")){
				response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
			}else if (per_type.equals("teacher")) {
				response.sendRedirect(request.getContextPath()+"/QueryTeacherServlet");
			}
			else if (per_type.equals("student")) {
				response.sendRedirect(request.getContextPath()+"/QueryStudentServlet");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/index.jsp?error=yes");
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
