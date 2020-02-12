package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pers.qlc.Student_sys.dao.UserDao;


public class InsertAminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
		String username=request.getParameter("admin_username");
		String password=request.getParameter("admin_password");
		Object[] objects=new Object[2];
		objects[0]=new String(username);
		objects[1]=new String(password);
		UserDao userDao=new UserDao();
		String sql="INSERT INTO Admin_info(Username,Password) VALUES (?,?)";
		userDao.UpdataUser(sql, objects);
		response.sendRedirect(request.getContextPath()+"/QueryAdminServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
