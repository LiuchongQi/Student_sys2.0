package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pers.qlc.Student_sys.dao.UserDao;
import pers.qlc.Student_sys.entity.Course;
import pers.qlc.Student_sys.entity.Teacher;


public class QueryTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	request.setCharacterEncoding("utf-8");  
	        response.setCharacterEncoding("utf-8");  
			
	        UserDao userDao=new UserDao();
			HttpSession session=request.getSession();
			String username=(String) session.getAttribute("loginName");
			
			Object[] objects=new Object[1];
			objects[0]=new String(username);
			
			//获取个人信息
			String sql1="select * from Teacher_info where Username=?";
			ArrayList<Teacher> arrayList1=userDao.QueryUser(Teacher.class, sql1, objects);
			Teacher teacher=arrayList1.get(0);
			request.setAttribute("Queryme_teacher", teacher);
			
			String sql2="select * from Course_info where Tno=?";
			ArrayList<Course> arrayList2=userDao.QueryUser(Course.class, sql2, objects);
			request.setAttribute("Queryme_course",arrayList2);
			
			request.getRequestDispatcher("/Teacher_page.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
