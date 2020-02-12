package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qlc.Student_sys.dao.UserDao;

public class InsertCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        
		String cno=request.getParameter("Cno");
		String cname=request.getParameter("Cname");
		String cteacher=request.getParameter("Cteacher");
		String cday=request.getParameter("Cday");
		String ctime=request.getParameter("Ctime");
		
		Object[] objects=new Object[5];
		objects[0]=new String(cno);
		objects[1]=new String(cname);
		objects[2]=new String(cteacher);
		objects[3]=new String(cday);
		objects[4]=new String(ctime);
		
		UserDao userDao=new UserDao();
		String sql="insert into Course_info(Cno,Cname,Tno,Cday,Ctime) values(?,?,?,?,?)";
		userDao.UpdataUser(sql,objects);
		response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
