package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.qlc.Student_sys.service.ChangePassService;

public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
		String new_pass=request.getParameter("new_password");
		HttpSession session=request.getSession(false);
		if(session==null){
			return;
		}
		String username=(String) session.getAttribute("loginName");
		String type=(String)session.getAttribute("type");
		ChangePassService changePassDao=new ChangePassService();
		changePassDao.updateUser(type,new_pass,username);
		if(type=="admin"){
			response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
		}
		else if(type=="teacher"){
			response.sendRedirect(request.getContextPath()+"/QueryTeacherServlet");
		}
		else if(type=="student"){
			response.sendRedirect(request.getContextPath()+"/QueryStudentServlet");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
