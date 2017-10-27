package final_Project_Servlet;

import java.io.IOException;
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
		
		//ForuseDAO fDao = ForuseDAO.getInstance();
		//fDao.login(request);
		//ServletContext sc = this.getServletContext();
		//MemberDao dao = (MemberDao)sc.getAttribute("memberDao");
		//member = dao.exist(req.getParameter("email"), req.getParameter("password"))
		//ServletContext sc = this.getServletContext();
		/*HttpSession session = request.getSession();
		
		
		String date = request.getParameter("date");
		StudentDAO sDao = new StudentDAO();
		ForuseVO fVo = new ForuseVO();
		fVo.setDate(date);
		
		
		//StudentDAO sDao = (StudentDAO)sc.getAttribute("stu_id");
		ForuseDAO fDao = ForuseDAO.getInstance();
		String stu_id =fDao.login(request);
		int result = fDao.getForuse(fVo);

		if(result == 1)
			
		{
			session.setAttribute(stu_id, fVo.getStu_id());
			session.setAttribute(date, fVo.getDate());
			StudentVO sVo = sDao.getMember(stu_id);
			session.setAttribute("loginUser", sVo);
			session.setAttribute("stu_change", sVo.getStu_change());
		}
		else{}
		RequestDispatcher dispatcher =request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request,response);
		*/
	
		
		HttpSession session =request.getSession();

		
		String loginUser1 = (String)session.getAttribute("loginUser1");
		String sql = "insert into foruse(stu_id, date, mn_price, f_use) values (?, ?, 3500, 'use') ";
		String sql2= "update student set stu_change = stu_change - 3500  where stu_id = ? ";
		
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
			pstmt.setString(2, a);
			
			pstmt1.setString(1, loginUser1);
			
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
