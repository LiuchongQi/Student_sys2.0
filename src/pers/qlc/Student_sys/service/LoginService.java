package pers.qlc.Student_sys.service;

import java.util.ArrayList;

import pers.qlc.Student_sys.dao.UserDao;
import pers.qlc.Student_sys.entity.Admin;
import pers.qlc.Student_sys.entity.Student;
import pers.qlc.Student_sys.entity.Teacher;

public class LoginService {
	public boolean Login(String userName,String pwd,String userType){
		UserDao userDao=new UserDao();
		Object[] objects=new Object[1];
		objects[0]=new String(userName);
		if(userType.equals("admin")){
			String sql="select Username,Password from Admin_info where Username=?";
			ArrayList<Admin> arrayList=userDao.QueryUser(Admin.class, sql, objects);
			if(arrayList==null||arrayList.isEmpty()){
				return false;
			}
			
			Admin admin=arrayList.get(0);
			if(admin.getUsername()==null){
				return false;
			}
			if(admin.getUsername().equals(userName)
					 && admin.getPassword().equals(pwd)){
				return true;
			}
		
			
		}else if (userType.equals("teacher")) {
			String sql="select Username,Password from Teacher_info where Username=?";
			ArrayList<Teacher> arrayList=userDao.QueryUser(Teacher.class, sql, objects);
			if(arrayList==null||arrayList.isEmpty()){
				return false;
			}
			
			Teacher teacher=arrayList.get(0);
			if(teacher.getUsername()==null){
				return false;
			}
			if(teacher.getUsername().equals(userName)
					 && teacher.getPassword().equals(pwd)){
				return true;
			}
		}else if (userType.equals("student")) {
			String sql="select Username,Password from Student_info where Username=?";
			ArrayList<Student> arrayList=userDao.QueryUser(Student.class, sql, objects);
			if(arrayList==null||arrayList.isEmpty()){
				return false;
			}
			
			Student student=arrayList.get(0);
			if(student.getUsername()==null){
				return false;
			}
			if(student.getUsername().equals(userName)
					 && student.getPassword().equals(pwd)){
				return true;
			}
		}
		
		return false;
		
	}
}
