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

import final_Project_Vo.ViewUseVO;
import final_Project_Vo.appViewUseVO;

public class ViewUseDAO {

	// 날짜입력
	// 날짜설정해주기

	private ViewUseDAO() {
	}

	private static ViewUseDAO instance = new ViewUseDAO();

	public static ViewUseDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");

		conn = ds.getConnection();
		return conn;
	}

	/*
	 * 
	 * Use AppServer
	 * 
	 * 
	 */

	// 일주일 짜리 리스트
	public List<appViewUseVO> appWeekCheckUse(String and_id) {

		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 7 day)) order by date";
		List<appViewUseVO> appWeekList = new ArrayList<appViewUseVO>();
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
					appViewUseVO ucVo = new appViewUseVO();

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
	public List<appViewUseVO> appMonthCheckUse(String and_id) {

		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
		List<appViewUseVO> appMonthList = new ArrayList<appViewUseVO>();
		
		
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
					appViewUseVO ucmVo = new appViewUseVO();

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
	public List<appViewUseVO> appThMonthCheckUse(String and_id) {

		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
		List<appViewUseVO> appThMonthList = new ArrayList<appViewUseVO>();
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
					appViewUseVO ucVo = new appViewUseVO();

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
	
	

	/*
	 * 
	 * Use ServerPage & DAO
	 * 
	 * 
	 */

	public List<ViewUseVO> checkUsage(HttpServletRequest request) {

		HttpSession session = request.getSession();

		String loginUser1 = (String) session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ?  order by date desc Limit 7";
		List<ViewUseVO> list = new ArrayList<ViewUseVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 날짜 넣어주

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				{

					ViewUseVO ucVo = new ViewUseVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getInt("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					list.add(ucVo);

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

		return list;
	}

	public List<ViewUseVO> checkWeekUsage(HttpServletRequest request) {

		HttpSession session = request.getSession();

		String loginUser1 = (String) session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 7 day)) order by date";
		List<ViewUseVO> weekList = new ArrayList<ViewUseVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				{

					ViewUseVO ucVo = new ViewUseVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getInt("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					weekList.add(ucVo);
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
		return weekList;
	}

	public List<ViewUseVO> checkMonthUsage(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String loginUser1 = (String) session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 1 month)) order by date";
		List<ViewUseVO> mthlyList = new ArrayList<ViewUseVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				{

					ViewUseVO ucVo = new ViewUseVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getInt("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					mthlyList.add(ucVo);
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
		return mthlyList;
	}

	public List<ViewUseVO> check3MonthUsage(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String loginUser1 = (String) session.getAttribute("loginUser1");
		String sql = "select * from foruse  where f_use='사용' and  stu_id = ? and date > date(subdate(curdate(), interval 3 month)) order by date";
		List<ViewUseVO> thMonthlyList = new ArrayList<ViewUseVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginUser1);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				{

					ViewUseVO ucVo = new ViewUseVO();

					ucVo.setStu_id(rs.getString("stu_id"));
					ucVo.setDate(rs.getString("date"));
					ucVo.setChain(rs.getString("chain"));
					ucVo.setMn_name(rs.getString("mn_name"));
					ucVo.setMn_price(rs.getInt("mn_price"));
					ucVo.setF_use(rs.getString("f_use"));
					thMonthlyList.add(ucVo);
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
		return thMonthlyList;

	}
}