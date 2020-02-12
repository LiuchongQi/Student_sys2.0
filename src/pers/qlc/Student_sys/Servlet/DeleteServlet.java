package pers.qlc.Student_sys.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qlc.Student_sys.service.DeleteService;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String type=request.getParameter("type");
		String course=request.getParameter("course");
		
		DeleteService deleteService=new DeleteService();
		
		
		if(course!=null){
			deleteService.DeleteUser(username, type,course);
			response.sendRedirect(request.getContextPath()+"/QueryStudentServlet");
		}
		else{
			deleteService.DeleteUser(username, type,null);
			response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
