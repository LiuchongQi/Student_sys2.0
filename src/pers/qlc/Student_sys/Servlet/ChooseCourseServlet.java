package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pers.qlc.Student_sys.dao.UserDao;


public class ChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserDao ud=new UserDao();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("loginName");
		String cno=(String)request.getParameter("course");
		Object[] obj=new Object[2];
		obj[0]=new String(cno);
		obj[1]=new String(username);
		String sql="insert into SC(Cno,Sno) values(?,?)";
		ud.UpdataUser(sql, obj);
		response.sendRedirect(request.getContextPath()+"/QueryStudentServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
