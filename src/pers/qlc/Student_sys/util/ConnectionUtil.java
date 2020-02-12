package pers.qlc.Student_sys.util;

import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.*;

public class ConnectionUtil {
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection=null;
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Student_sys","sa","sql");
			}catch(Exception e){
				e.printStackTrace();
			}
			return connection;
	}
	/**
	 * �ر���Դ
	 */
	public static void closeDb(Object...args){
		if(args==null){
			return;
		}
		try {
			for(int i=0;i<args.length;i++){
				if(args[i] instanceof PreparedStatement && args[i]!=null){
					((PreparedStatement)args[i]).close();
				}
				if(args[i] instanceof ResultSet && args[i]!=null){
					((ResultSet)args[i]).close();
				}
				if(args[i] instanceof Connection && args[i]!=null){
					((Connection)args[i]).close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ��������
	 * @param sql
	 * @param paramsValue
	 */
	public static boolean update(String sql,Object[] paramsValue){
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isOk=false;
		try{
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			int count = pstmt.getParameterMetaData().getParameterCount();			
			if (paramsValue != null && paramsValue.length > 0) {
				for(int i=0;i<count;i++) {
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			pstmt.executeUpdate();
			isOk=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDb(pstmt,con);
		}
		return isOk;	
	}
	/**
	 * ��ѯ����
	 * @param sql
	 * @param paramsValue
	 * @param clazz
	 * @return
	 */
	public static <T> ArrayList<T> query(String sql, Object[] paramsValue,Class<T> clazz){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// ���صļ���
			ArrayList<T> list = new ArrayList<T>();
			// ����
			T t = null;
			
			// 1. ��ȡ����
			con = ConnectionUtil.getConnection();
			// 2. ����stmt����
			pstmt = con.prepareStatement(sql);
			if (paramsValue != null && paramsValue.length > 0) {
				for (int i=0; i<paramsValue.length; i++) {
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			
			// 4. ִ�в�ѯ
			rs = pstmt.executeQuery();
			// 5. ��ȡ�����Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();
			// ---> ��ȡ�еĸ���
			int columnCount = rsmd.getColumnCount();
			
			// 6. ����rs
			while (rs.next()) {
				// Ҫ��װ�Ķ���
				t=clazz.newInstance();
				
				// 7. ����ÿһ�е�ÿһ��, ��װ����
				for (int i=0; i<columnCount; i++) {
					Object val=rs.getObject(i+1);
					String name=rsmd.getColumnLabel(i+1);
					java.lang.reflect.Field field=clazz.getDeclaredField(name);
					if(!Modifier.isPublic(field.getModifiers())){
						field.setAccessible(true);
						field.set(t,val);
					}
				}
				// �ѷ�װ��ϵĶ�����ӵ�list������
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.closeDb(con, pstmt, rs);
		}
	}
}
