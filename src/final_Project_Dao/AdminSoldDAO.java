package final_Project_Dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import final_Project_Vo.MenuVO;

public class AdminSoldDAO {

	private AdminSoldDAO() {};
	
	private static AdminSoldDAO instance = new AdminSoldDAO();
	
	public static AdminSoldDAO getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		
		
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}
	
	/*
	 * 
	 * app -> Server
	 * 
	 * 
	 */
	
	public void appSold(String mn_name, String chain ,String mn_sold){
		
		int result  = -1;
		
		
		String sql =  "update menu set mn_sold= ? where mn_name= ? and chain= ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try{
			
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, mn_sold);
			pstmt.setString(2, mn_name);
			pstmt.setString(3, chain);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return;
	}
	
	
	
}
