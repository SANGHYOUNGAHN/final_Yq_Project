package final_Project_Servlet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import final_Project_Dao.RechargeDAO;
import final_Project_Dao.StudentDAO;
import final_Project_Vo.ForuseVO;
import final_Project_Vo.RechargeVO;
import final_Project_Vo.StudentVO;

/**
 * Servlet implementation class MenuRcgServlet
 */
@WebServlet("/Recharge.do")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Connection getConnection() throws Exception {
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
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Main_Page.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		


	//	String stu_id= request.getParameter("stu");
	//	String date = request.getParameter("date");
		
	//	String stu_change = request.getParameter("stu_change");
	//	String mn_price = request.getParameter("recharge_mn");
		
		
		
	//	MenuRcgVO mRVo = new MenuRcgVO();
	//	mRVo.setStu_id(stu_id);
	//	mRVo.setDate(date);
	//	mRVo.setRecharge_mn(Integer.parseInt(recharge_mn));
		
	//	ForuseVO fVo = new ForuseVO();
	//	fVo.setStu_id(stu_id);
	//	fVo.setMn_price(Integer.parseInt(mn_price));
	//	fVo.setDate(date);
		
		
	//	MenuRcgDAO mRdao = MenuRcgDAO.getInstance();
	//	StudentDAO sDao = StudentDAO.getInstance();
		
		
	//	int result = mRdao.getValueRecharge_mn(mRVo);
		
	//	HttpSession session = request.getSession();
		

	//	if(result == 1)
	//	{
	//		//MenuRcgVO mRVo = mRdao.getValueRecharge_mn(mRVo)
	//		session.setAttribute("stu",mRVo.getStu_id());
	//		session.setAttribute("date", mRVo.getDate());
	//		session.setAttribute("recharge_mn", mRVo.getRecharge_mn());
	//		StudentVO sVo = sDao.getMember(stu_id);
	//		session.setAttribute("loginUser", sVo);
	//		session.setAttribute("stu_id", mRVo.getStu_id());
	//		session.setAttribute("mn_price", mRVo.getRecharge_mn());
			
			
	//	}
	//	else{}
	
		
		HttpSession session = request.getSession();
		
	
		String recharge_mn =request.getParameter("recharge_mn");
		
		String loginUser1= (String)session.getAttribute("loginUser1");
	
		
		RechargeVO mRVo =new RechargeVO();
		StudentDAO sDao =new StudentDAO();
		
		mRVo.setRecharge_mn(Integer.parseInt(recharge_mn));
		//String sql = "INSERT INTO recharge(stu_id, date, recharge_mn) VALUES (?,?,?)";
		String sql1 = "INSERT INTO foruse(stu_id, date, mn_price, f_use) VALUES (?, ?, ?, '충전')";
		String sql2 = "UPDATE student SET stu_change = stu_change + ?  where stu_id = ?";	
		
		
		Connection conn =null;
		//PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2= null;
		
		
		//날짜 
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String a = df.format(d);
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false);
			
			//pstmt = conn.prepareStatement(sql);
			pstmt1= conn.prepareStatement(sql1);
			pstmt2= conn.prepareStatement(sql2);
			
			pstmt1.setString(1, loginUser1);
			pstmt1.setString(2, a);
			pstmt1.setInt(3, mRVo.getRecharge_mn());
			
			//pstmt1.setInt(1, mRVo.getRecharge_mn());
			pstmt2.setInt(1, mRVo.getRecharge_mn());
			pstmt2.setString(2, loginUser1);
			
			//pstmt2.setString(1, loginUser1);
			//pstmt2.setString(2,a);
			//pstmt2.setInt(3, mRVo.getRecharge_mn());
			
			//pstmt.executeUpdate();
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			
			conn.commit();
			StudentVO sVo = sDao.getMember(loginUser1);
			session.setAttribute("loginUser", sVo);
			
		}catch(Exception e)
		{
			try{
				conn.rollback();
			}catch(SQLException e1){
				e.printStackTrace();;
			}
		}finally{
			try{
				if(pstmt1 != null) pstmt1.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student_Recharge.jsp");
		dispatcher.forward(request, response);
	}

}
