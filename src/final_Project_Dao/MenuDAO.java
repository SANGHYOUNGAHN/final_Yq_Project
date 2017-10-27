package final_Project_Dao;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;

import final_Project_Vo.MenuVO;

public class MenuDAO {
	
	
	//get date(CALENDAR)
	public class getCalender{
	public String cc(){
				
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		return a;
			
	}
	}
	
	private MenuDAO(){		
	}
	
	private static MenuDAO instance = new MenuDAO();
	
	public static MenuDAO getInstance() {
		return instance;
	}
	
	//get to connection
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	

	//인성관일일메뉴(메인화면)
	public List<MenuVO> selectInSungMenu(){
		
		String sql ="select * from menu";
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//ResultSet rc =null;
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
	
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					if(rs.getString("chain").equals("인성관")&&rs.getString("mn_date").equals(gc.cc()))
					{
						MenuVO mVo = new MenuVO();
						
						mVo.setMn_date(rs.getString("mn_date"));
						mVo.setChain(rs.getString("chain"));
						mVo.setMn_type(rs.getString("mn_type"));
						mVo.setMn_name(rs.getString("mn_name"));
						mVo.setMn_price(rs.getInt("mn_price"));
						mVo.setMn_sold(rs.getString("mn_sold"));
						list.add(mVo); // Arraylist에 객체 추가
					}
				} // while문 끝
		} catch(Exception e ){
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
				
	}	
	
	
	
	
	//환경과학대일일메뉴
	public List<MenuVO> selectHwanMenu(){
		
		String sql ="select * from menu";
		List<MenuVO> list= new ArrayList<MenuVO>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//ResultSet rc =null;
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
	
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					if(rs.getString("chain").equals("환경과학대")&&rs.getString("mn_date").equals(gc.cc()))
					{
						MenuVO mVo = new MenuVO();
						
						mVo.setMn_date(rs.getString("mn_date"));
						mVo.setChain(rs.getString("chain"));
						mVo.setMn_type(rs.getString("mn_type"));
						mVo.setMn_name(rs.getString("mn_name"));
						mVo.setMn_price(rs.getInt("mn_price"));
						mVo.setMn_sold(rs.getString("mn_sold"));
						list.add(mVo); // Arraylist에 객체 추가
					}
				} // while문 끝
			
		} catch(Exception e ){
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
				
	}	

	
	//기숙사일일메뉴
	public List<MenuVO> selectDormMenu(){
		
		String sql ="select * from menu";
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//ResultSet rc =null;
		getCalender gc = new getCalender();
		//getdate
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
	
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					if(rs.getString("chain").equals("생활관")&&rs.getString("mn_date").equals(gc.cc()))
					{
						MenuVO mVo = new MenuVO();
						
						mVo.setMn_date(rs.getString("mn_date"));
						mVo.setChain(rs.getString("chain"));
						mVo.setMn_type(rs.getString("mn_type"));
						mVo.setMn_name(rs.getString("mn_name"));
						mVo.setMn_price(rs.getInt("mn_price"));
						mVo.setMn_sold(rs.getString("mn_sold"));
						list.add(mVo); // Arraylist에 객체 추가
					}
				} // while문 끝
			
		} catch(Exception e ){
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
			
	}
	public List<MenuVO> selectWeekMenu(){
		
		String sql ="select * from menu";
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
	
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					{
						MenuVO mVo = new MenuVO();
						
						mVo.setMn_date(rs.getString("mn_date"));
						mVo.setChain(rs.getString("chain"));
						mVo.setMn_type(rs.getString("mn_type"));
						mVo.setMn_name(rs.getString("mn_name"));
						mVo.setMn_price(rs.getInt("mn_price"));
						
						list.add(mVo); // Arraylist에 객체 추가
					}
				} // while문 끝
			
		} catch(Exception e ){
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
