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
 * Servlet implementation class AdminHwanTotServlet
 */
@WebServlet("/AdminHwan.do")
public class AdminHwanTotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHwanTotServlet() {
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
		String url = "Admin_HwanTot_Foruse.jsp";
		
		String con =request.getParameter("con");
		
		AdminTotForuseDAO atDao= AdminTotForuseDAO.getInstance();
		List<ViewUseVO> hwanList = atDao.getHwanTot(con, request);
		List<ViewUseVO> hwanAwardList= atDao.getHwanAward(con, request);
		
		HttpSession session = request.getSession();
		session.setAttribute("hwanTotalList",hwanList);
		session.setAttribute("hwanAwList",hwanAwardList);
				
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
				
	}

}
