package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import final_Project_Servlet.AdminInsertMenuServlet;
import final_Project_Vo.AdminInsertVO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdminInsertMenuDAO {

	private AdminInsertMenuDAO(){

	}
	
	private static AdminInsertMenuDAO instance = new AdminInsertMenuDAO();
	
	
	public static AdminInsertMenuDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn= ds.getConnection();
		return conn;
	}
	
	public int insertMenu(AdminInsertVO AiVo){
		
		int result = -1;
		String sql = "INSERT INTO menu VALUES (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//AdminInsertVO insert = null;
			
				pstmt.setString(1, AiVo.getMn_id());
				pstmt.setString(2, AiVo.getMn_date());
				pstmt.setString(3, AiVo.getMn_name());
				pstmt.setInt(4, AiVo.getMn_price());
				pstmt.setString(5, AiVo.getChain());
				pstmt.setString(6, AiVo.getMn_type());
				
				result = pstmt.executeUpdate();
				
		} catch(Exception e)
		{
			e.printStackTrace();
			
		}finally{ 
			try{
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
	
	
