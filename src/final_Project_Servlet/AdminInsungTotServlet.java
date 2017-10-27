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

import final_Project_Dao.AdminTotForuseDAO;
import final_Project_Vo.ViewUseVO;

/**
 * Servlet implementation class AdminInsungTotServlet
 */
@WebServlet("/AdminInsung.do")
public class AdminInsungTotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsungTotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url ="Admin_InsungTot_Foruse";
		String con = request.getParameter("con");
		
		AdminTotForuseDAO atDao = AdminTotForuseDAO.getInstance();
		List<ViewUseVO> inList = atDao.getInsungTot(con, request);
		List<ViewUseVO> inAwardList= atDao.getInsungAward(con, request);
		HttpSession session = request.getSession();
		
		session.setAttribute("inTotList",inList);
		session.setAttribute("inAwList",inAwardList);
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

}

