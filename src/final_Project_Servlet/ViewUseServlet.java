package final_Project_Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

import final_Project_Dao.ViewRcgDAO;
import final_Project_Dao.ViewUseDAO;
import final_Project_Vo.ViewRcgVO;
import final_Project_Vo.ViewUseVO;

/**
 * Servlet implementation class UseChkServlet
 */



@WebServlet("/UseChk.do")
public class ViewUseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Connection getConnection() throws Exception{
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
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String url ="Student_Foruse.jsp";
		ViewUseDAO Cdao = ViewUseDAO.getInstance();
		List<ViewUseVO> useChkList = Cdao.checkUsage(request);
		List<ViewUseVO> useChkWeekList= Cdao.checkWeekUsage(request);
		List<ViewUseVO> useChkMonthList= Cdao.checkMonthUsage(request);
		List<ViewUseVO> useChkThMonthList= Cdao.check3MonthUsage(request);
		
		ViewRcgDAO Rdao = ViewRcgDAO.getInstance();
		List<ViewRcgVO> rcgChkList = Rdao.checkRcg(request);
		List<ViewRcgVO> rcgChkWeekList = Rdao.checkWeekRcg(request);
		List<ViewRcgVO> rcgChkMonthList = Rdao.checkMonthRcg(request);
		List<ViewRcgVO> rcgChkThMonthList = Rdao.check3MonthRcg(request);
			
		HttpSession session = request.getSession();
		
		session.setAttribute("rcgChkList", rcgChkList);
		session.setAttribute("rcgChkWeekList", rcgChkWeekList);
		session.setAttribute("rcgChkMonthList", rcgChkMonthList);
		session.setAttribute("rcgChkThMonthList", rcgChkThMonthList);
		
		session.setAttribute("useChkList", useChkList);
		session.setAttribute("useChkWeekList", useChkWeekList);
		session.setAttribute("useChkMonthList", useChkMonthList);
		session.setAttribute("useChkThMonthList", useChkThMonthList);
		
		request.setAttribute("rcgChkList", rcgChkList);
		request.setAttribute("rcgChkWeekList", rcgChkWeekList);
		request.setAttribute("rcgChkMonthList", rcgChkMonthList);
		request.setAttribute("rcgChkThMonthList", rcgChkThMonthList);
		
		request.setAttribute("useChkList", useChkList);
		request.setAttribute("useChkWeekList", useChkWeekList);
		request.setAttribute("useChkMonthList", useChkMonthList);
		request.setAttribute("useChkThMonthList", useChkThMonthList);
		
		
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}
}
