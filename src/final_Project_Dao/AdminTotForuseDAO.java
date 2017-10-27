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

import final_Project_Vo.ForuseVO;
import final_Project_Vo.ViewUseVO;

public class AdminTotForuseDAO {

	private AdminTotForuseDAO() {}
	
	private static AdminTotForuseDAO instance = new AdminTotForuseDAO();
	
	public static AdminTotForuseDAO getInstance() {
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
	
	
	public List<ViewUseVO> getInsungTot(String con, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<ViewUseVO> insungTotList= new ArrayList<ViewUseVO>();
		
		
		
		String sql= "select sum(mn_price) as insungTotal from foruse where chain='insung' and f_use='use' and date like concat(?,'%')";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ViewUseVO fVo = new ViewUseVO();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				fVo.setInsungTot(rs.getInt("insungTotal"));
				insungTotList.add(fVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		try{
			if(rs!= null)rs.close();
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return insungTotList;
	}
	public List<ViewUseVO> getHwanTot(String con , HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<ViewUseVO> hwanTotList= new ArrayList<ViewUseVO>();
		
		//String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql= "select sum(mn_price) as hwanTotal from foruse where chain='hwan' and f_use='use' and date like concat(?,'%')";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ViewUseVO hVo = new ViewUseVO();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				hVo.setHwanTot(rs.getInt("hwanTotal"));
				hwanTotList.add(hVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		try{
			if(rs!= null)rs.close();
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return hwanTotList;
	}
	public List<ViewUseVO> getDormTot(String con, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<ViewUseVO> dormTotList= new ArrayList<ViewUseVO>();
		
		//String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql= "select sum(mn_price) as dormTotal from foruse where chain='dorm' and f_use='use' and  date like concat(?,'%')";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ViewUseVO fVo = new ViewUseVO();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				fVo.setDormTot(rs.getInt("dormTotal"));
				dormTotList.add(fVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		try{
			if(rs!= null)rs.close();
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return dormTotList;
	}
	
	public List<ViewUseVO> getInsungAward(String con, HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		List<ViewUseVO> insungList = new ArrayList<ViewUseVO>();
		
		String sql="select mn_name, count(*) as insungkwan from foruse where chain='insung' and f_use='use' and date like concat(?,'%') group by mn_name order by insungkwan desc limit 5";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ViewUseVO vVo = new ViewUseVO();
				vVo.setMn_name(rs.getString("mn_name"));
				vVo.setInsungAward(rs.getInt("insungkwan"));
				insungList.add(vVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!= null)rs.close();
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return insungList;
	}
	
	public List<ViewUseVO> getHwanAward(String con, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<ViewUseVO> hwankwaList = new ArrayList<ViewUseVO>();
		
		//String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql="select mn_name, count(*) as hwankwadae from foruse where chain='hwan'and f_use='use' and date like concat(?,'%') group by mn_name order by hwankwadae desc limit 5";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ViewUseVO HVo = new ViewUseVO();
				HVo.setMn_name(rs.getString("mn_name"));
				HVo.setHwanAward(rs.getInt("hwankwadae"));
				hwankwaList.add(HVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!= null)rs.close();
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return hwankwaList;
	}
	
	public List<ViewUseVO> getDormAward(String con, HttpServletRequest request)
	{
		//HttpSession session = request.getSession();
		List<ViewUseVO> dormList = new ArrayList<ViewUseVO>();
		
		//String loginUser1 = (String)session.getAttribute("loginUser1");
		
		String sql="select mn_name, count(*) as dormitory from foruse where chain='dorm' and date like concat(?,'%') group by mn_name order by dormitory desc limit 5";
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try{
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, con);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ViewUseVO DVo = new ViewUseVO();
				DVo.setMn_name(rs.getString("mn_name"));
				DVo.setDormAward(rs.getInt("dormitory"));
				dormList.add(DVo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!= null)rs.close();
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dormList;
	}
}