package final_Project_Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import final_Project_Dao.StudentDAO;

import final_Project_Vo.StudentVO;

/**
 * Servlet implementation class ForuseServlet
 */
@WebServlet("/Foruse.do")
public class ForuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForuseServlet() {
        super();
        // TODO Auto-generated constructor sub
    }
    public Connection getConnection1() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		conn = ds.getConnection();
		return conn;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//시도 1차 
		//HttpSession session = request.getSession();
		//String stu_id = (String)request.getAttribute("stu_id");
		
		//시도 2차
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session =request.getSession();

		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		if(loginUser1.equals(false)){
			System.out.println("결제되지않습니다.");
		}
		
		String sql = "update student set stu_change= stu_change-3500 where stu_id=?";
		//System.out.println("결제가 되지 않습니다");
		//String sql= "update student set stu_change =If(stu_change < 3500 , stu_change , stu_change- 3500) where stu_id = ?" ;
		String sql2 = "insert into foruse(stu_id, date, mn_price, f_use) values (?, ?, 3500, '사용') ";
		

		Connection conn = null;
		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 = null;

		
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		StudentDAO sDao = StudentDAO.getInstance();
		
		try{
			conn = getConnection1();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt1= conn.prepareStatement(sql2);
			
			
			pstmt.setString(1, loginUser1);
		
			pstmt1.setString(1, loginUser1);
			pstmt1.setString(2, a);
			
			
			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			
			
			
			conn.commit();
			
			
			StudentVO sVo = sDao.getMember(loginUser1);
			session.setAttribute("loginUser", sVo);
			
			
		}catch(Exception e){
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("Student_Info.jsp");
		dispatcher.forward(request,response);
	}

}
