package pers.qlc.Student_sys.service;

import pers.qlc.Student_sys.dao.UserDao;

public class DeleteService {
	public void DeleteUser(String userName,String type,String course){
		if(type==null||userName==null)return;
		UserDao userDao=new UserDao();
		if(course==null){
			Object[] obj=new Object[1];
			if("admin".equals(type)){
				String sql="delete from Admin_info where Username=?";
				obj[0]=new String(userName);
				userDao.UpdataUser(sql,obj);
			}else if("course".equals(type)){
				String sql="delete from Course_info where Cno=?";
				obj[0]=new String(userName);
				userDao.UpdataUser(sql,obj);
			}else if("teacher".equals(type)){
				String sql="delete from Teacher_info where Username=?";	
				obj[0]=new String(userName);
				userDao.UpdataUser(sql,obj);
			}else if("student".equals(type)){
				String sql="delete from Student_info where Username=?";
				obj[0]=new String(userName);
				userDao.UpdataUser(sql,obj);
			}
		}else{
			if("sc".equals(type)){
				Object[] obj=new Object[2];
				String sql="delete from SC where Sno=? and Cno=?";
				obj[0]=new String(userName);
				obj[1]=new String(course);
				userDao.UpdataUser(sql,obj);
			}
		}
		
	}
}
