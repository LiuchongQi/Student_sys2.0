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
import pers.qlc.Student_sys.entity.Student;

public class QueryStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserDao userDao=new UserDao();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("loginName");
		
		Object[] obj=new Object[1];
		obj[0]=new String(username);
		
		String sql1="select * from Student_info where Username=?";		
		ArrayList<Student> arrayList1=userDao.QueryUser(Student.class, sql1, obj);
		Student student=arrayList1.get(0);
		request.setAttribute("Queryme_student", student);
		
		String sql2="select * from Course_info;";
		ArrayList<Course> arrayList2=userDao.QueryUser(Course.class, sql2, null);
		request.setAttribute("Queryme_course",arrayList2);
		
		String sql3="select Course_info.Cno,Cname,Tno,Cday,Ctime from Course_info,SC where sc.Cno=Course_info.Cno and sc.Sno=?";
		ArrayList<Course> arrayList3=userDao.QueryUser(Course.class, sql3, obj);
		request.setAttribute("Queryme_mycourse",arrayList3);
		
		request.getRequestDispatcher("/Student_page.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
