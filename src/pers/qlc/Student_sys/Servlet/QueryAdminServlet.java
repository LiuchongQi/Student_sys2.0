package pers.qlc.Student_sys.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qlc.Student_sys.dao.UserDao;
import pers.qlc.Student_sys.entity.Admin;
import pers.qlc.Student_sys.entity.Course;
import pers.qlc.Student_sys.entity.Student;
import pers.qlc.Student_sys.entity.Teacher;

public class QueryAdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
		UserDao userDao=new UserDao();
		String sql="select * from Admin_info;";
		ArrayList<Admin> arrayList=userDao.QueryUser(Admin.class,sql,null);
		request.setAttribute("QueryAdmin", arrayList);
		
		String sql1="select * from Teacher_info;";
		ArrayList<Teacher> arrayList1=userDao.QueryUser(Teacher.class,sql1,null);
		request.setAttribute("QueryTeacher", arrayList1);
		
		String sql2="select * from Student_info;";
		ArrayList<Student> arrayList2=userDao.QueryUser(Student.class,sql2,null);
		request.setAttribute("QueryStudent", arrayList2);
		
		String sql3="select * from Course_info;";
		ArrayList<Course> arrayList3=userDao.QueryUser(Course.class,sql3,null);
		request.setAttribute("QueryCourse", arrayList3);
		
		request.getRequestDispatcher("/Admin_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
