package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost/acors";
	private static final String password = "emilylove";
	private static final String user = "root";
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, user,password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int executeUpdate(Connection conn, String sql, Object...params){
		int rst = -1;
		PreparedStatement pstmt = null;
		try{
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++)
			{
				pstmt.setObject(i+1, params[i]);
			}
			rst = pstmt.executeUpdate();
			conn.commit();
		}catch(SQLException sqle){
			sqle.printStackTrace();
			try{
				conn.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rst;
	}
	
	public static ResultSet executeQuery(Connection conn, String sql, Object...params){
		ResultSet rs = null;
		
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++)
			{
				pstmt.setObject(i+1, params[i]);
			}
			rs = pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		if(null != rs){
			try{
				rs.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
		if(null != stmt){
			try{
				stmt.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(null != conn){
			try{
				conn.close();
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
}
