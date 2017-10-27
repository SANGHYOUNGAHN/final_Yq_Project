package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import final_Project_Vo.ForuseVO;
import final_Project_Vo.RechargeVO;
import final_Project_Vo.StudentVO;

public class ForuseDAO {
	
	private ForuseDAO(){}
	
	private static ForuseDAO instance = new ForuseDAO();

	public static ForuseDAO getInstance(){
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
	public String login(HttpServletRequest request)
	{
		
		HttpSession session  =request.getSession();
		String stu_id = (String)session.getAttribute("stu_id");
		
		
		return stu_id;
	}
	
	public List<ForuseVO> getTotalForuse(String condition , HttpServletRequest request) 
	{
		
		HttpSession session  =request.getSession();
		List<ForuseVO> list = new ArrayList<ForuseVO>();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		
		//List<ForuseVO> totList = new ArrayList<ForuseVO>();
		
		String sql ="select sum(mn_price) as foruseTotal from foruse where stu_id = ? and f_use='use' and date LIKE concat(?,'%')  ";
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ForuseVO fVo = new ForuseVO();
		
		try{
			
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,loginUser1); 
			pstmt.setString(2,condition);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				fVo.setSumTot(rs.getInt("foruseTotal"));
				list.add(fVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
		try{
			if(rs!= null)rs.close();
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	return list;
	}
	
}