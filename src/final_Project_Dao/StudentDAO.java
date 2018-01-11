package final_Project_Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import final_Project_Vo.StudentVO;

public class StudentDAO {

	public StudentDAO() {

	}

	private static StudentDAO instance = new StudentDAO();

	public static StudentDAO getInstance() {
		return instance;
	}

	// get to connection
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
	 * server -> app ( to Server give id) student page
	 * 
	 */

	public ArrayList<StudentVO> appLoginList(String stu_id) {

		String sql = "select * from student where stu_id = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<StudentVO> loginList = new ArrayList<StudentVO>();
		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				StudentVO sVO = new StudentVO();
				sVO.setStu_id(rs.getString("stu_id"));
				sVO.setStu_pw(rs.getString("stu_pw"));
				sVO.setStu_name(rs.getString("stu_name"));
				sVO.setStu_change(rs.getString("stu_change"));

				loginList.add(sVO);

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

		return loginList;

	}

	public List<StudentVO> userList() {

		String sql = "SELECT * FROM student";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<StudentVO> userList = new ArrayList<StudentVO>();
		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentVO sVO = new StudentVO();

				sVO.setStu_id(rs.getString("stu_id"));
				sVO.setStu_pw(rs.getString("stu_pw"));
				sVO.setStu_name(rs.getString("stu_name"));
				sVO.setStu_change(rs.getString("stu_change"));
				userList.add(sVO);
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

		return userList;

	}

	// Using check user
	public int userCheck(String stu_id, String stu_pw) {
		int result = -1;
		String sql = "select stu_pw from student where stu_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("stu_pw") != null && rs.getString("stu_pw").equals(stu_pw)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
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
		return result;
	}

	public StudentVO getMember(String stu_id) {
		StudentVO mVo = null;
		String sql = "select * from student where stu_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mVo = new StudentVO();
				mVo.setStu_id(rs.getString("stu_id"));
				mVo.setStu_name(rs.getString("stu_name"));
				mVo.setStu_change(rs.getString("stu_change"));
				mVo.setStu_pw(rs.getString("stu_pw"));

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
		return mVo;

	}

	// TODO Auto-generated method stub

}