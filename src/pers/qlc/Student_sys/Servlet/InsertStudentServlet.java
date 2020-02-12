package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qlc.Student_sys.dao.UserDao;

public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8"); 
        
        String sno=request.getParameter("Sno");
        String password=request.getParameter("password");
        String sanme=request.getParameter("Sname");
        String ssex=request.getParameter("Ssex");
        String sage=request.getParameter("Sage");
        String sdept=request.getParameter("Sdept");
        String sclass=request.getParameter("Sclass");
        String sgrade=request.getParameter("Sgrade");
        
        Object[] objects=new Object[8];
        objects[0]=new String(sno);
        objects[1]=new String(password);
        objects[2]=new String(sanme);
        objects[3]=new String(ssex);
        objects[4]=new String(sage);
        objects[5]=new String(sdept);
        objects[6]=new String(sclass);
        objects[7]=new String(sgrade);
        
        UserDao userDao=new UserDao();
		String sql="insert into Student_info(Username,Password,Sname,Ssex,Sage,Sclass,Sdept,Grade)values(?,?,?,?,?,?,?,?)";
		userDao.UpdataUser(sql, objects);
		response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
