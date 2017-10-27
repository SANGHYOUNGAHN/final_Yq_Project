package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import final_Project_Vo.AdminVO;

public class AdminDAO {
	
	private AdminDAO(){
		
	}
	
	private static AdminDAO instance = new AdminDAO();
	
	public static AdminDAO getInstance() {
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
	
	public int adminUserCheck(String ad_id, String ad_pw){
		int result = -1;
		String sql = "select ad_pw from admin where ad_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ad_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("ad_pw")!= null && rs.getString("ad_pw").equals(ad_pw)){
					result=1;
				} else {
					result=0;
				}
				} else{
					result=-1;
				}
				}catch (Exception e){
					e.printStackTrace();
				} finally{
					try{
						if(rs!= null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn != null)conn.close();			
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	return result;
	}
	public AdminVO getAdminMember(String ad_id) {
		AdminVO mVo = null;
		String sql= "select * from admin where ad_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, ad_id); 
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				mVo = new AdminVO();
				mVo.setAd_id(rs.getString("ad_id"));
				mVo.setAd_name(rs.getString("ad_name"));
				mVo.setAd_pw(rs.getString("ad_pw"));
			}
		} catch(Exception e){
			e.printStackTrace();}
		finally{
			try{
				if(rs!= null)rs.close();
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;	
	}
}


	
