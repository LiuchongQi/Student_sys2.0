package pers.qlc.Student_sys.dao;

import java.util.ArrayList;

import pers.qlc.Student_sys.util.ConnectionUtil;

public class UserDao {
	public  <T> ArrayList<T> QueryUser(Class<T> cls,String sql,Object[] args){
		ArrayList<T> arrayList=ConnectionUtil.query(sql, args, cls);
		return arrayList;
	}
	public boolean UpdataUser(String sql,Object[] args){
		 return ConnectionUtil.update(sql, args);
	}
}