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