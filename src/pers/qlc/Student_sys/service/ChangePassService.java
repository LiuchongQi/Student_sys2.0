package pers.qlc.Student_sys.service;

import pers.qlc.Student_sys.dao.UserDao;

public class ChangePassService {

	public void updateUser(String type,String password,String username) {
		Object[] objects = new Object[2];
		UserDao userDao=new UserDao();
		if(type.equals("admin")){
			String sql="update Admin_info set Password = ? where username=?";
			objects[0]=new String(password);
			objects[1]=new String(username);
			userDao.UpdataUser(sql, objects);
		}
		else if(type.equals("teacher")){
			String sql="update Teacher_info set Password = ? where username=?";
			objects[0]=new String(password);
			objects[1]=new String(username);
			userDao.UpdataUser(sql, objects);
		}
		else if(type.equals("student")){
			String sql="update Student_info set Password = ? where username=?";
			objects[0]=new String(password);
			objects[1]=new String(username);
			userDao.UpdataUser(sql, objects);
		}
		
	}
}
