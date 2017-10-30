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

	private ForuseDAO() {
	}

	private static ForuseDAO instance = new ForuseDAO();

	public static ForuseDAO getInstance() {
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

	public String login(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String stu_id = (String) session.getAttribute("stu_id");

		return stu_id;
	}

	public void appBuyMenu(String buy_id, String mn_name, String chain, String mn_price) {

		int menu_Price = Integer.parseInt(mn_price);
		String sql = "insert into foruse(stu_id, date, chain, mn_name,mn_price, f_use) values(?,?,?,?,?,'use')";
		String sql2 = "update student set stu_change = stu_change - ? where stu_id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);

		try {

			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);

			pstmt.setString(1, buy_id);
			pstmt.setString(2, a);
			pstmt.setString(3, chain);
			pstmt.setString(4, mn_name);
			pstmt.setInt(5, menu_Price);

			pstmt1.setInt(1, menu_Price);
			pstmt1.setString(2, buy_id);

	
			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public void appStuGift(String send_id, String re_id, String stu_price) {

		int stu_Recharge = Integer.parseInt(stu_price);

		String sql = "insert into foruse(stu_id, date, mn_price, f_use) values(?,?,?,'Gift')";
		String sql2 = "update student set stu_change = stu_change + ? where stu_id = ? ";
		String sql3 = "update student set stu_change = stu_change - ? where stu_id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);

		try {

			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);
			pstmt2 = conn.prepareStatement(sql3);

			pstmt.setString(1, send_id);
			pstmt.setString(2, a);
			pstmt.setInt(3, stu_Recharge);

			pstmt1.setInt(1, stu_Recharge);
			pstmt1.setString(2, re_id);

			pstmt2.setInt(1, stu_Recharge);
			pstmt2.setString(2, send_id);

			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return;
	}

	public void appStuRecharge(String stu_id, String stu_price) {

		int stu_Recharge = Integer.parseInt(stu_price);

		String sql = "insert into foruse(stu_id, date, mn_price, f_use) values(?,?,?,'Recharge')";
		String sql2 = "update student set stu_change = stu_change + ? where stu_id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);

		try {

			conn = getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql2);

			pstmt.setString(1, stu_id);
			pstmt.setString(2, a);
			pstmt.setInt(3, stu_Recharge);

			pstmt1.setInt(1, stu_Recharge);
			pstmt1.setString(2, stu_id);

			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return;
	}

	public List<ForuseVO> getTotalForuse(String condition, HttpServletRequest request) {

		HttpSession session = request.getSession();
		List<ForuseVO> list = new ArrayList<ForuseVO>();

		String loginUser1 = (String) session.getAttribute("loginUser1");

		// List<ForuseVO> totList = new ArrayList<ForuseVO>();

		String sql = "select sum(mn_price) as foruseTotal from foruse where stu_id = ? and f_use='use' and date LIKE concat(?,'%')  ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ForuseVO fVo = new ForuseVO();

		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUser1);
			pstmt.setString(2, condition);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				fVo.setSumTot(rs.getInt("foruseTotal"));
				list.add(fVo);
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

}