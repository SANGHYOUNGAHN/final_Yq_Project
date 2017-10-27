package final_Project_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import final_Project_Dao.ViewRcgDAO;
import final_Project_Vo.ViewRcgVO;

/**
 * Servlet implementation class ViewRcgServlet
 */
@WebServlet("/ViewRcg.do")
public class ViewRcgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRcgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "Student_Rcg_View.jsp";
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
		
		
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}
