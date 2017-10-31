package final_Project_Dao;
//String radioValue = request.getParameter("밸류값이름")
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;

import final_Project_Servlet.StudentLoginServlet;
import final_Project_Vo.ForuseVO;
import final_Project_Vo.RechargeVO;
import final_Project_Vo.StudentVO;
import final_Project_Vo.appViewRcgVO;

public class RechargeDAO {
	
	public class getCalender{
		public String cc(){
			
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String a = df.format(d);
			return a;
		}
	}
	
	private RechargeDAO(){
			
		}
	
	private static RechargeDAO instance = new RechargeDAO();
	
	public static RechargeDAO getInstance() {
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
	 * Search -> Recharge
	 * stu_id, date
	 * 
	 *
	 */
	public List<ForuseVO> appSearchRecharge(String and_id , String date){
		
		String sql ="select sum(mn_price) as rechargeTotal from foruse where stu_id = ? and f_use='Recharge' and date LIKE concat(?,'%')"; 
		
		List<ForuseVO> searchList = new ArrayList<ForuseVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
				conn=getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, and_id);
				pstmt.setString(2, date);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					
					ForuseVO fVO = new ForuseVO();
					
					fVO.setSumRcgTot(rs.getInt("rechargeTotal"));
					searchList.add(fVO);
					
					
				}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		return searchList;
		

	}
	
	
	
	
	
	
	//버튼눌럿을때 value값 받아오기 
	//해당 로그인 아이디와 리차지테이블 조인
	
	//스튜던트 테이블의 잔액과 밸류값을 더하고
	//그런 다음에 해당 로그인 잔액 추가됨.
	
	//1000원을 라디오 버튼으로 설정했을
	public List<ForuseVO> getTotalRcg(String condition , HttpServletRequest request) 
	{
		
		HttpSession session  =request.getSession();
		List<ForuseVO> rcgList = new ArrayList<ForuseVO>();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
	
		
		String sql ="select sum(mn_price) as rechargeTotal from foruse where stu_id = ? and f_use='recharge' and date LIKE concat(?,'%')  ";
		
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
				fVo.setSumRcgTot(rs.getInt("rechargeTotal"));
				rcgList.add(fVo);
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
	
	return rcgList;
	}

	
}
