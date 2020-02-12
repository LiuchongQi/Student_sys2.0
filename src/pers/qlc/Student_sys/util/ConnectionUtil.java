package pers.qlc.Student_sys.util;

import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.*;

public class ConnectionUtil {
	/**
	 * 获取数据库连接
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
	 * 关闭资源
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
	 * 更新数据
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
	 * 查询数据
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
			// 返回的集合
			ArrayList<T> list = new ArrayList<T>();
			// 对象
			T t = null;
			
			// 1. 获取连接
			con = ConnectionUtil.getConnection();
			// 2. 创建stmt对象
			pstmt = con.prepareStatement(sql);
			if (paramsValue != null && paramsValue.length > 0) {
				for (int i=0; i<paramsValue.length; i++) {
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			
			// 4. 执行查询
			rs = pstmt.executeQuery();
			// 5. 获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// ---> 获取列的个数
			int columnCount = rsmd.getColumnCount();
			
			// 6. 遍历rs
			while (rs.next()) {
				// 要封装的对象
				t=clazz.newInstance();
				
				// 7. 遍历每一行的每一列, 封装数据
				for (int i=0; i<columnCount; i++) {
					Object val=rs.getObject(i+1);
					String name=rsmd.getColumnLabel(i+1);
					java.lang.reflect.Field field=clazz.getDeclaredField(name);
					if(!Modifier.isPublic(field.getModifiers())){
						field.setAccessible(true);
						field.set(t,val);
					}
				}
				// 把封装完毕的对象，添加到list集合中
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
