package final_Project_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import final_Project_Vo.ViewRcgVO;
import final_Project_Vo.ViewUseVO;
import final_Project_Vo.appViewRcgVO;
import final_Project_Vo.appViewUseVO;

public class ViewRcgDAO {

	
	
	private ViewRcgDAO(){}
	
	private static ViewRcgDAO instance = new ViewRcgDAO();
	
	public static ViewRcgDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}
	
	/*
	 * 
	 * app -> view Recharge 
	 * Week , Month , ThreeMonth
	 * 
	 */
	
	public List<appViewRcgVO> appWeekCheckRcg(String and_id) {

		String sql = "select * from foruse  where f_use='Recharge' and  stu_id = ? and date > date(subdate(curdate(), interval 7 day)) order by date";
		List<appViewRcgVO> appWeekList = new ArrayList<appViewRcgVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, and_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				{
					appViewRcgVO ucVo = new appViewRcgVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getString("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					appWeekList.add(ucVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return appWeekList;
	}

	// 한달짜리 리스트
	public List<appViewRcgVO> appMonthCheckRcg(String and_id) {

		String sql = "select * from foruse  where f_use='Recharge' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
		List<appViewRcgVO> appMonthList = new ArrayList<appViewRcgVO>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, and_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				{
					appViewRcgVO ucmVo = new appViewRcgVO();

					ucmVo.setStu_id(rs.getString("stu_id"));
					ucmVo.setDate(rs.getString("date"));
					ucmVo.setChain(rs.getString("chain"));
					ucmVo.setMn_name(rs.getString("mn_name"));
					ucmVo.setMn_price(rs.getString("mn_price"));
					ucmVo.setF_use(rs.getString("f_use"));
					appMonthList.add(ucmVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return appMonthList;

	}

	// 3개월
	public List<appViewRcgVO> appThMonthCheckRcg(String and_id) {

		String sql = "select * from foruse  where f_use='Recharge' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
		List<appViewRcgVO> appThMonthList = new ArrayList<appViewRcgVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, and_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				{
					appViewRcgVO ucVo = new appViewRcgVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getString("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					appThMonthList.add(ucVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return appThMonthList;

	}
	
	
	
	
	
	
	
	
	public List<ViewRcgVO>checkRcg(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='recharge' and  stu_id = ? order by date desc Limit 7";
		List<ViewRcgVO> list = new ArrayList<ViewRcgVO>();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				{
				
					ViewRcgVO rcVo = new ViewRcgVO();
					
					rcVo.setStu_id(rs.getString("stu_id"));
					rcVo.setDate(rs.getString("date"));
					rcVo.setChain(rs.getString("chain"));
					rcVo.setMn_name(rs.getString("mn_name"));
					rcVo.setMn_price(rs.getInt("mn_price"));
					rcVo.setF_use(rs.getString("f_use"));
					
					list.add(rcVo);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	public List<ViewRcgVO>checkWeekRcg(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		String sql = "select * from foruse where f_use='recharge' and stu_id= ? and date > date(subdate(curdate(), interval 7 day)) order by date";
		List<ViewRcgVO> weeklist = new ArrayList<ViewRcgVO>();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				{
				
					ViewRcgVO rcVo = new ViewRcgVO();
					
					rcVo.setStu_id(rs.getString("stu_id"));
					rcVo.setDate(rs.getString("date"));
					rcVo.setChain(rs.getString("chain"));
					rcVo.setMn_name(rs.getString("mn_name"));
					rcVo.setMn_price(rs.getInt("mn_price"));
					rcVo.setF_use(rs.getString("f_use"));
					
					weeklist.add(rcVo);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return weeklist;
	
	}
	
	public List<ViewRcgVO>checkMonthRcg(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='recharge' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
		List<ViewRcgVO> mthlyList = new ArrayList<ViewRcgVO>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				{
					
					ViewRcgVO rcVo = new ViewRcgVO();
					
					rcVo.setStu_id(rs.getString("stu_id"));
					rcVo.setDate(rs.getString("date"));
					rcVo.setChain(rs.getString("chain"));
					rcVo.setMn_name(rs.getString("mn_name"));
					rcVo.setMn_price(rs.getInt("mn_price"));
					rcVo.setF_use(rs.getString("f_use"));
					
					mthlyList.add(rcVo);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return mthlyList;	
	}
	
	public List<ViewRcgVO>check3MonthRcg(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='use' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
		List<ViewRcgVO> thMonthlyList = new ArrayList<ViewRcgVO>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser1);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				{
					
					ViewRcgVO rcVo = new ViewRcgVO();
					
					rcVo.setStu_id(rs.getString("stu_id"));
					rcVo.setDate(rs.getString("date"));
					rcVo.setChain(rs.getString("chain"));
					rcVo.setMn_name(rs.getString("mn_name"));
					rcVo.setMn_price(rs.getInt("mn_price"));
					rcVo.setF_use(rs.getString("f_use"));
					thMonthlyList.add(rcVo);		
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return thMonthlyList;	
		
	}
}