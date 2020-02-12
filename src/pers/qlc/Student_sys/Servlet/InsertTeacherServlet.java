package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qlc.Student_sys.dao.UserDao;

public class InsertTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8"); 
        
        String Tno=request.getParameter("Tno");
        String password=request.getParameter("password");
        String Tname=request.getParameter("Tname");
        String Tsex=request.getParameter("Tsex");
        String Tage=request.getParameter("Tage");
        String Tjob=request.getParameter("Tjob");
        
        Object[] objects=new Object[6];
        objects[0]=new String(Tno);
        objects[1]=new String(password);
        objects[2]=new String(Tname);
        objects[3]=new String(Tsex);
        objects[4]=new String(Tage);
        objects[5]=new String(Tjob);
        
        UserDao userDao=new UserDao();
		String sql="insert into Teacher_info(Username,Password,Tname,Tsex,Tage,Tjob) values(?,?,?,?,?,?)";
		userDao.UpdataUser(sql, objects);
		response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
